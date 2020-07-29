import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; // Importado de HttpCommons ya que es propio de Angular
import { Persona } from 'src/app/Modelo/Persona'; //Importamos la clase

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  //persona:Persona; en getPersonas se importa el objeto <Persona>

  constructor(private http:HttpClient) { }

  Url= 'http://localhost:8080/api/personas'; //Proyecto Backend


  getPersonas(){
    return this.http.get<Persona[]>(this.Url)   //se debe crear los modelos en este caso Modelo/Persona.ts, e invoco los datos por medio de URL
  }

  createPersona(persona:Persona) {
    return this.http.post<Persona>(this.Url, persona);
  }

  getPersonaId(id:number){
    return this.http.get<Persona>(this.Url+"/"+id);
  }

  updatePersona(persona:Persona){
    return this.http.put<Persona>(this.Url+"/"+persona.id, persona);
  }

  deletePersona(persona:Persona){
    return this.http.delete<Persona>(this.Url+"/"+persona.id);
  }

}
