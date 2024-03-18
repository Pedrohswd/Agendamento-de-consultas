import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormControl, Validators, NgForm } from '@angular/forms';
import { fuseAnimations } from '@fuse/animations';
import { Unidade } from 'app/models/unidade';
import { UnidadeService } from '../unidade.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-unidade-create',
  templateUrl: './unidade-create.component.html',
  encapsulation: ViewEncapsulation.None,
  animations: fuseAnimations
})
export class UnidadeCreateComponent implements OnInit {

  unidade: Unidade = {
    id: '',
    nome: '',
    gestao: '',
    cnpj: '',
    endereco: {
      id: '',
      rua: '',
      numero: '',
      complemento: '',
      cidade: '',
      cep: ''
    },
    cnes: '',
  }

  nome: FormControl = new FormControl(null, Validators.required);
  gestao: FormControl = new FormControl(null, Validators.required);
  cnpj: FormControl = new FormControl(null, Validators.required);
  cnes: FormControl = new FormControl(null, Validators.required);
  rua: FormControl = new FormControl(null, Validators.required);

  numero: FormControl = new FormControl(null, Validators.required);

  cidade: FormControl = new FormControl(null, Validators.required);

  cep: FormControl = new FormControl(null, Validators.required);

  isLinear = false;

  constructor(private service: UnidadeService,
    private router: Router) {

  }

  ngOnInit(): void {

  }

  validaCampos(): boolean {
    return this.nome.valid && this.cnes.valid
      && this.cidade.valid && this.rua.valid
      && this.cep.valid && this.numero.valid
      && this.gestao.valid
  }

  create(): void {
    this.service.create(this.unidade).subscribe(resposta => {
      //this.toast.success('Unidade cadastrada com sucesso', 'Cadastro');
      this.router.navigate(["unidade"])
    }, ex => {
      if (ex.error.errors) {
        ex.error.errors.forEach(element => {
          //this.toast.error(element.message);
        });
      } else {
        //this.toast.error(ex.error.message);
      }
    })
  }

}
