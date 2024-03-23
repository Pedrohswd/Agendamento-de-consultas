import { FormGroup } from "@angular/forms";

export class Endereco {
    id?: any;
    rua: string;
    numero: string;
    complemento: string;
    cidade: string;
    cep: string;

    constructor(enderecoForm: FormGroup){
        this.id = enderecoForm.value.id;
        this.rua = enderecoForm.value.rua;
        this.numero = enderecoForm.value.numero;
        this.complemento = enderecoForm.value.complemento;
        this.cidade = enderecoForm.value.cidade;
        this.cep = enderecoForm.value.cep;
    }
}