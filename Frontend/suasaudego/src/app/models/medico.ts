import { FormGroup } from "@angular/forms";

export class Medico {
    id?: any;
    nome: string;
    crm: string;
    dt_nascimento: string;

    constructor(medicoForm: FormGroup){
        this.nome = medicoForm.value.nome;
        this.crm = medicoForm.value.crm;
        this.dt_nascimento = medicoForm.value.dt_nascimento;
    }
}