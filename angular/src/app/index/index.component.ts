import { Component, OnInit } from '@angular/core';
import { Grupo } from '../domain/grupo';
import { GruposService } from '../grupo/service/grupos.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  listaGrupos: Grupo[];


  constructor(private service: GruposService,
  private router : Router) { }

  ngOnInit(): void {
    //listamos todos los grupos
    this.service.getListGrupos().subscribe(
      //asignamos los valores a la variable
      listaGrupos => this.listaGrupos = listaGrupos
    );

    console.log(this.listaGrupos);

  }





}
