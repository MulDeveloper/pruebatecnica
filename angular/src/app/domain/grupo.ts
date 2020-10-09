import { Usuario } from './usuario';

export class Grupo{
    idGrupo: number;
    listaPersonas: Usuario[];
    descripcionGrupo: string;

    public constructor(init?: Partial<Grupo>) {
        Object.assign(this, init);
    }
}
