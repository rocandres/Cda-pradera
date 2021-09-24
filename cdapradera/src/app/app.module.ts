import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReservaComponent } from './reserva/reserva.component';
import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './header/header.component';
import { ReservaClienteComponent } from './reserva-cliente/reserva-cliente.component';
import { CraerDisponibilidadComponent } from './craer-disponibilidad/craer-disponibilidad.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


const appRoutes:Routes=[
{path:'',component: ReservaComponent},
{path:'reservaCliente',component:ReservaClienteComponent},
{path:'crear-agenda',component:CraerDisponibilidadComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    ReservaComponent,
    HeaderComponent,
    ReservaClienteComponent,
    CraerDisponibilidadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(
      appRoutes
    ),
    BrowserAnimationsModule,
    NgbModule,
    HttpClientModule,
    FormsModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
