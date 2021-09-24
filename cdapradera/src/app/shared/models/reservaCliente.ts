export class ReservaCliente{
 
    constructor(
       public id: number,
       public cedula: String,
       public nombre: String,
       public telefono: String,
       public placa: String,
       public tipo: String,
       public email: String,
       public fecha: Date,
       public hora: Date
    ) { }

}