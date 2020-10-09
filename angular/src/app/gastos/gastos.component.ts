import { Component, OnInit } from '@angular/core';
import { Gasto } from '../domain/gasto';
import { Grupo } from '../domain/grupo';
import { Usuario } from '../domain/usuario';
import { GruposService } from '../grupo/service/grupos.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-gastos',
  templateUrl: './gastos.component.html',
  styleUrls: ['./gastos.component.css']
})
export class GastosComponent implements OnInit {

  gasto: Gasto = new Gasto();
  listPersons: Usuario[];
  id: string;
  grupo: Grupo = new Grupo();
  persona: Usuario = new Usuario();

  constructor(private service: GruposService,
  private router : Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    //get users of this group
    this.service.getUsersByGroup(this.id).subscribe(
      listPersons => this.listPersons = listPersons
    );

  }

  public addGasto(){
    this.grupo.idGrupo = +this.id
    this.gasto.idGrupoFk = this.grupo;
    this.gasto.idPersonaFk = this.persona;

    console.log(this.persona);
    console.log(this.gasto);

    this.service.addPagoToGroup(this.gasto).subscribe();
    location.replace('/show/'+this.id);
  }


}
