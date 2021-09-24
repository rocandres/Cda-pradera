import { Component, OnInit } from '@angular/core';
import { BackendService } from '../service/backend.service';
import { Persona } from '../shared/models/Persona';
import { ReservaCliente } from '../shared/models/reservaCliente';

@Component({
  selector: 'app-reserva-cliente',
  templateUrl: './reserva-cliente.component.html',
  styleUrls: ['./reserva-cliente.component.css']
})
export class ReservaClienteComponent implements OnInit {

  constructor(private service: BackendService) { }
  public reservasCliente: ReservaCliente[];
  public persona= new Persona('','','','');
  public cedula="";

  ngOnInit(): void {
    this.cedula="";
  }

  getReservasCliente(){
    this.service.getReservaCliente(this.cedula).subscribe((result:any)=>{
      this.reservasCliente=result.data;
      if(this.reservasCliente != null){
        this.persona.cedula=this.reservasCliente[0].cedula;
        this.persona.nombre=this.reservasCliente[0].nombre;
        this.persona.telefono=this.reservasCliente[0].telefono;
        this.persona.email=this.reservasCliente[0].email;
      
      }else{
        this.persona.cedula="";
        this.persona.nombre="";
        this.persona.telefono="";
        this.persona.email="";
      }
      console.log(result.data);
    });

  }


}
