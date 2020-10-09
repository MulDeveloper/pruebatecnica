import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { GruposService } from '../grupo/service/grupos.service';
import { Usuario } from '../domain/usuario';
@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  id: string;
  user: Usuario = new Usuario();

  constructor(private service: GruposService,
  private router : Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
  }

  public addUser(): void {
    //llamamos al servicio de grupo e insertamos el Usuario
    this.service.addUserToGroup(this.id,this.user).subscribe();
    location.replace('/show/'+this.id);
  }

}
