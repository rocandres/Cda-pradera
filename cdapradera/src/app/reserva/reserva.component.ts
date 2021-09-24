import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { BackendService } from '../service/backend.service';
import { Disponibilidad } from '../shared/models/disponibilidad';
import { Persona } from '../shared/models/Persona';
import { Reserva } from '../shared/models/reserva';
import { Vehiculo } from '../shared/models/vehiculo';

@Component({
  selector: 'app-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.css']

})
export class ReservaComponent implements OnInit {

  constructor(private service: BackendService) {}
  public disponibilidades: Disponibilidad[];
  public tipoVehiculos: Vehiculo[];
  public reserva = new Reserva("","","","","","","");
  public persona= new Persona("","","","");
  public bandera=0;
  public banderaGuardar=0;
  public banderaPersona=false;
  public respuesta="";

  ngOnInit(): void {
    this.getVehiculos();
    this.getAgenda();


    
  }


  getVehiculos(){
    this.service.getTipoVehiculos().subscribe((result:any)=>{
      this.tipoVehiculos=result.data;
    });

  }

  getAgenda(){
    this.service.getDisponibilidad().subscribe((result:any)=>{
      this.disponibilidades=result.data;
      console.log(this.disponibilidades);
    });

  }
  showForm(row){
    this.bandera=1;
    this.banderaGuardar=0;
    this.reserva.disponibildad=row.id;
  }

  creaReserva(){
    this.service.crearReserva(this.reserva).subscribe((result:any)=>{
      this.respuesta=result.data;
      this.reserva.cedula="";
      this.reserva.disponibildad="";
      this.reserva.email="";
      this.reserva.nombre="";
      this.reserva.placa="";
      this.reserva.telefono="";
      this.reserva.vehiculo="";
      this.bandera=0;
      this.banderaGuardar=1;
      this.getAgenda();


    });

  }

  consultarPersona(cedula){
    
    this.service.getPersona(cedula).subscribe((result:any)=>{
      this.persona=result.data;
      console.log(result);
      
      if(this.persona != null){
        this.reserva.email=this.persona.email;
        this.reserva.nombre=this.persona.nombre;
        this.reserva.telefono=this.persona.telefono;
        this.banderaPersona=true;
      }else{
        this.banderaPersona=false;
      }
      
      
    });
    

  }
 


}
