import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CrearDisponibilidad } from '../shared/models/crear-disponibilidad-models';
import { Reserva } from '../shared/models/reserva';

const API='http://localhost:8090/cda/';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  constructor(private http:HttpClient) { }

  getDisponibilidad(){
    return this.http.get(API + 'Disponibles');
  }

  getReservaCliente(cedula:String){
    return this.http.get(API + 'Reservas/'+cedula);
  }

  crearAgenda(agenda: CrearDisponibilidad){
    return this.http.post(API+"crearDisponibilidad",agenda);

  }

  getTipoVehiculos(){
    return this.http.get(API + 'Vehiculos')
  }

  crearReserva(reserva:Reserva){
    return this.http.post(API+"CrearReserva",reserva);

  }

  getPersona(cedula:String){
    return this.http.get(API + 'persona/'+cedula);
  }

}
