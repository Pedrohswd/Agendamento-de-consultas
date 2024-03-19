import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import {
    FormBuilder,
    FormControl,
    Validators,
    NgForm,
    FormGroup,
} from '@angular/forms';
import { fuseAnimations } from '@fuse/animations';
import { Unidade } from 'app/models/unidade';
import { UnidadeService } from '../unidade.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-unidade-create',
    templateUrl: './unidade-create.component.html',
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations,
})
export class UnidadeCreateComponent implements OnInit {
    unidadeForm: FormGroup;
    unidadeFormEnd: FormGroup;
    isLinear = false;

    constructor(
        private service: UnidadeService,
        private router: Router,
        private FormBuilder: FormBuilder
    ) {
    }

    ngOnInit(): void {
      this.unidadeForm = this.FormBuilder.group({
        nome: [null, Validators.required],
        gestao: [null, Validators.required],
        cnpj: [null],
        cnes: [null, Validators.required],
    });
    this.unidadeFormEnd = this.FormBuilder.group({
        rua: [null, Validators.required],
        numero: [null, Validators.required],
        complemento: [null],
        cidade: [null, Validators.required],
        cep: [null, Validators.required],
    });
    }

    isValid(): boolean{
      return this.unidadeForm.valid && this.unidadeFormEnd.valid
    }

    create(): void {
        this.service.create(this.unidadeForm, this.unidadeFormEnd).subscribe(
            (resposta) => {
                //this.toast.success('Unidade cadastrada com sucesso', 'Cadastro');
                this.router.navigate(["unidade"]);
            },
            (ex) => {
                if (ex.error.errors) {
                    ex.error.errors.forEach((element) => {
                        //this.toast.error(element.message);
                    });
                } else {
                    //this.toast.error(ex.error.message);
                }
            }
        );
    }
}
