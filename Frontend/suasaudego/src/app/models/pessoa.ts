import { Endereco } from "./endereco";

export interface Pessoa {
    id?: any;
    nome: string;
    cpf: string;
    dataNascimento: any;
    endereco: Endereco;
}
