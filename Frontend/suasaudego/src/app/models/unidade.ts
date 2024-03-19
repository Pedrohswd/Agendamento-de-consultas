import { FormGroup } from "@angular/forms";
import { Endereco } from "./endereco";

export class Unidade {
    id?: any;
    nome: string;
    gestao: string;
    cnpj?:string;
    endereco: Endereco;
    cnes: string;

    constructor(unidadeForm: FormGroup, unidadeFormEnd: FormGroup){
        this.nome = unidadeForm.value.nome;
        this.gestao = unidadeForm.value.gestao;
        this.cnpj = unidadeForm.value.cnpj;
        this.cnes = unidadeForm.value.cnes;
        this.endereco = new Endereco(unidadeFormEnd);
    }

}