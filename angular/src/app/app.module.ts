import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes, ActivatedRoute } from '@angular/router';

import { AppComponent } from './app.component';
import { IndexComponent } from './index/index.component';
import { GrupoComponent } from './grupo/create/grupo.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ShowgroupComponent } from './grupo/showgroup/showgroup.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { GastosComponent } from './gastos/gastos.component';

const routes: Routes = [
  {path: '', redirectTo:'/index', pathMatch:'full'},
  {path: 'addgrupo', component: GrupoComponent},
  {path: 'index', component: IndexComponent},
  {path: 'show/:id', component: ShowgroupComponent},
  {path: 'usuario/:id', component: UsuarioComponent},
  {path: 'gasto/:id', component: GastosComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    GrupoComponent,
    ShowgroupComponent,
    UsuarioComponent,
    GastosComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
