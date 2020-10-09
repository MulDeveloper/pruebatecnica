import { Grupo } from './grupo';
import { Usuario } from './usuario';
export class Gasto{
  idPago:number;
  importe: number;
  descripcionPago: string;
  fechaPago: Date;
  idGrupoFk: Grupo;
  idPersonaFk: Usuario;

}
