import { Component, OnInit } from '@angular/core';
import { Grupo } from '../../domain/grupo';
import { GruposService } from '../service/grupos.service';

@Component({
  selector: 'app-grupo',
  templateUrl: './grupo.component.html',
  styleUrls: ['./grupo.component.css']
})
export class GrupoComponent implements OnInit {

  public grupo: Grupo = new Grupo();

  constructor(private service: GruposService) { }

  ngOnInit(): void {
  }

  public createGrupo(): void{
    this.service.saveGroup(this.grupo).subscribe();
    location.replace('/index');

  }

}
