import { FormGroup } from "@angular/forms";

export class Endereco {
    id?: any;
    rua: string;
    numero: string;
    complemento: string;
    cidade: string;
    cep: string;

    constructor(unidadeFormEnd: FormGroup){
        this.rua = unidadeFormEnd.value.rua;
        this.numero = unidadeFormEnd.value.numero;
        this.complemento = unidadeFormEnd.value.complemento;
        this.cidade = unidadeFormEnd.value.cidade;
        this.cep = unidadeFormEnd.value.cep;
    }
}