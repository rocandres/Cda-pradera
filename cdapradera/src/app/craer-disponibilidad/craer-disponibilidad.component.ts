import { Component, OnInit } from '@angular/core';
import { BackendService } from '../service/backend.service';
import { CrearDisponibilidad } from '../shared/models/crear-disponibilidad-models';
import { Disponibilidad } from '../shared/models/disponibilidad';

@Component({
  selector: 'app-craer-disponibilidad',
  templateUrl: './craer-disponibilidad.component.html',
  styleUrls: ['./craer-disponibilidad.component.css']
})
export class CraerDisponibilidadComponent implements OnInit {

  constructor(private service: BackendService) { }
  public crear_disponibilidad = new CrearDisponibilidad("","","");
  public disponibilidades: Disponibilidad[];
  public bandera=0;
  public respuesta:String;

  ngOnInit(): void {
    this.getDisponibles();

    

  }

  creaDisponibilidad(){
    console.log(this.crear_disponibilidad);
    this.service.crearAgenda(this.crear_disponibilidad).subscribe((result:any)=>{
      this.crear_disponibilidad.fecha="";
      this.crear_disponibilidad.hora_fin="";
      this.crear_disponibilidad.hora_inicio="";
      this.bandera=1;
      this.respuesta=result.data;
      this.getDisponibles();
    });


  }


  getDisponibles(){
    this.service.getDisponibilidad().subscribe((result:any)=>{
      this.disponibilidades=result.data;
      console.log(this.disponibilidades);
    });
  }



}
