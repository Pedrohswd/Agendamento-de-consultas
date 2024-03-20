import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { fuseAnimations } from '@fuse/animations';
import { MedicoService } from '../medico.service';
import { Router } from '@angular/router';
import { Medico } from 'app/models/medico';


@Component({
  selector: 'app-medico-create',
  templateUrl: './medico-create.component.html',
  encapsulation: ViewEncapsulation.None,
  animations: fuseAnimations,
})
export class MedicoCreateComponent implements OnInit {
  medicoForm: FormGroup;
  isLinear = false;

  constructor(
    private service: MedicoService,
    private router: Router,
    private FormBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.medicoForm = this.FormBuilder.group({
      nome: [null, Validators.required],
      crm: [null, Validators.required],
      dt_nascimento: [null, Validators.required],
    });
  }

  create(): void {
    this.service.create(this.medicoForm).subscribe(
      (res) => {
        this.router.navigate(["medico"]);
      },
      (ex) => {
        if (ex.error.errors) {
          ex.error.erros.forEach((element) => {
            //this.toast.error(element.message);
          });
        }
        else {
          //this.toast.error(ex.error.message);
        }
      }
    );
  }
}
