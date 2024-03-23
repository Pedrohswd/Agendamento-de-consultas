import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UnidadeService } from '../unidade.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Unidade } from 'app/models/unidade';

@Component({
    selector: 'app-unidade-update',
    templateUrl: './unidade-update.component.html',
    styleUrls: ['./unidade-update.component.scss'],
})
export class UnidadeUpdateComponent implements OnInit {
    unidadeForm: FormGroup;
    unidadeFormEnd: FormGroup;
    unidades: Unidade[] = [];
    isLinear = false;
    id: any;

    constructor(
        private formBuilder: FormBuilder,
        private service: UnidadeService,
        private route: ActivatedRoute,
        private _router: Router,
    ) {
        this.unidadeForm = this.formBuilder.group({
            id: [null],
            nome: ['', Validators.required],
            gestao: ['', Validators.required],
            cnpj: [''],
            cnes: ['', Validators.required],
        });
        this.unidadeFormEnd = this.formBuilder.group({
            id: [null],
            rua: [null, Validators.required],
            numero: [null, Validators.required],
            complemento: [null],
            cidade: [null, Validators.required],
            cep: [null, Validators.required],
        });

        this.route.params.subscribe((params) => {
            this.service
                .getCertificateById(this.route.snapshot.paramMap.get('cnes'))
                .subscribe((unidade) => {
                    
                    this.unidadeForm.setValue({
                        id: unidade.id,
                        nome: unidade.nome,
                        gestao: unidade.gestao,
                        cnpj: unidade.cnpj,
                        cnes: unidade.cnes,
                    });
                    this.unidadeFormEnd.setValue({
                        id: unidade.endereco.id,
                        rua: unidade.endereco.rua,
                        numero: unidade.endereco.numero,
                        complemento: unidade.endereco.complemento,
                        cidade: unidade.endereco.cidade,
                        cep: unidade.endereco.cep,
                    });
                });
        });
    }

    ngOnInit(): void {
    }

    update(): void{
        this.service.update(this.unidadeForm, this.unidadeFormEnd).subscribe(
            (resposta) => {
                //this.toast.success('Unidade cadastrada com sucesso', 'Cadastro');
                this._router.navigate(["unidade"]);
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
