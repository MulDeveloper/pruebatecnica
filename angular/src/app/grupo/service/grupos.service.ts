import { Injectable } from '@angular/core';
import { of, Observable } from 'rxjs';
import { Grupo } from '../../domain/grupo';
import { Usuario } from '../../domain/usuario';
import { Gasto } from '../../domain/gasto';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GruposService {

  private END_POINT_GRUPOS_LIST: string = 'http://localhost:8080/grupo/list';
  private END_POINT_GRUPOS_ADD: string = 'http://localhost:8080/grupo/add';
  private END_POINT_GRUPOS_GET: string = 'http://localhost:8080/grupo/';
  private END_POINT_GRUPOS_GET_USERS: string = 'http://localhost:8080/grupo/listByGroup/';
  private END_POINT_GRUPOS_GET_GASTOS: string = 'http://localhost:8080/gastos/list/';
  private END_POINT_ADD_USER: string = 'http://localhost:8080/grupo/addPersona/';
  private END_POINT_ADD_GASTO: string = 'http://localhost:8080/gastos/add/';


  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json', 'Access-Control-Allow-Headers': 'Content-Type'});


  constructor(private http: HttpClient) { }

  getListGrupos():Observable<Grupo[]>{
    return this.http.get<Grupo[]>(this.END_POINT_GRUPOS_LIST);
  }

  saveGroup(g: Grupo): Observable<Grupo>{
    return this.http.post<Grupo>(this.END_POINT_GRUPOS_ADD, g, {headers: this.httpHeaders});
  }


  getGroupById(id: string):Observable<Grupo>{
    return this.http.get<Grupo>(this.END_POINT_GRUPOS_GET+id,{headers: this.httpHeaders});
  }


  getUsersByGroup(id:string):Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.END_POINT_GRUPOS_GET_USERS+id,{headers: this.httpHeaders});
  }

  getGastosByGroup(id:string):Observable<Gasto[]>{
    return this.http.get<Gasto[]>(this.END_POINT_GRUPOS_GET_GASTOS+id,{headers: this.httpHeaders});
  }

  addUserToGroup(id:string, u: Usuario): Observable<string>{
    return this.http.post<string>(this.END_POINT_ADD_USER+id, u, {headers: this.httpHeaders});
  }

  addPagoToGroup(pago: Gasto):Observable<Gasto>{
    return this.http.post<Gasto>(this.END_POINT_ADD_GASTO, pago, {headers: this.httpHeaders});
  }

}
