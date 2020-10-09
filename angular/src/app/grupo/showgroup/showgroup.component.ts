import { Component, OnInit, Input } from '@angular/core';
import { GruposService } from '../service/grupos.service';
import { Grupo } from '../../domain/grupo';
import { Usuario } from '../../domain/usuario';
import { Gasto } from '../../domain/gasto';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-showgroup',
  templateUrl: './showgroup.component.html',
  styleUrls: ['./showgroup.component.css']
})
export class ShowgroupComponent implements OnInit {

  grupo: Grupo;
  id: string;
  listaGastos: Gasto[];
  balanceMap: Map<number, number> = new Map();
  media: number;
  listPersons: Usuario[];


  constructor(private service: GruposService,
  private router : Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    //cargamos los datos del grupo
    this.service.getGroupById(this.id).subscribe(
      //asignamos
      grupo => this.grupo = grupo

    );

    //list all persons of that group
    this.service.getUsersByGroup(this.id).subscribe(
      listPersons => this.listPersons = listPersons
    );

    this.loadGastos();
  }



  loadGastos(){
    //cargamos los gastos para este grupo en concreto
    this.service.getGastosByGroup(this.id).subscribe(
      listaGastos => this.listaGastos = listaGastos,
      error =>{
        console.log('error')
      },
      () => {
        //this.clearArray();
        this.getBalance();
      }
    )

  }

  getBalance(){

    //obtenemos el balance de gastos del grupo
    let total = 0;
    this.listaGastos.forEach(function (value) {
      total += value.importe;
    });

    //dividimos para obtener la media
     this.media = total / this.listPersons.length;

    //obtenemos lo que ha pagado cada uno e insertamos el resultado del balance al map

    for (let gasto of this.listaGastos) {
      if(this.balanceMap.has(gasto.idPersonaFk.idPersona)){
        //sumamos el valor que haya en el balancemap
        let newTotal = this.balanceMap.get(gasto.idPersonaFk.idPersona) + gasto.importe;
        this.balanceMap.set(gasto.idPersonaFk.idPersona, newTotal)
      }
      else{
        //creamos nueva entrada
        this.balanceMap.set(gasto.idPersonaFk.idPersona, gasto.importe);
      }
    }

    //si un usuario no ha pagado nada lo insertamos tambien en el Map

    for(let persona of this.listPersons){
      //si no esta en la lista de gastos lo metemos con valor 0
      if(!this.listaGastos.find(e => e.idPersonaFk.idPersona === persona.idPersona)){
        //console.log(persona.nombrePersona, ' no ha pagado nada');
        this.balanceMap.set(persona.idPersona, 0);
      }
    }





  }

  clearArray(){
    let index = this.listaGastos.findIndex(d => d.descripcionPago === 'NO DATA');
    this.listaGastos.splice(index, 1);
  }




  balance(){

  }

  public add(){
    this.router.navigate(['/gasto',this.id]);
  }

  public addMiembro(){
    this.router.navigate(['/usuario',this.id]);
  }


}
