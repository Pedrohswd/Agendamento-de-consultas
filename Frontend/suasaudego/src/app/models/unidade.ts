import { Endereco } from "./endereco";

export interface Unidade {
    id?: any;
    nome: string;
    gestao: string;
    cnpj?:string;
    endereco: Endereco;
    cnes: string;
}