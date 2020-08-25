import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Persona } from 'src/app/Modelo/Persona';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ServiceService {

  constructor(private http:HttpClient) { }

  //Proyecto Backend en Spring
  Url = 'http://150.136.217.38:8080/api/personas';

  getPersonas() {
    return this.http.get<Persona[]>(this.Url);
  }

  createPersona(persona:Persona) {
    return this.http.post<Persona>(this.Url, persona);
  }

  getPersonaId(id:number) {
    return this.http.get<Persona>(this.Url+"/"+id);
  }

  updatePersona(persona:Persona) {
    return this.http.put<Persona>(this.Url+"/"+persona.id, persona);
  }

  deletePersona(persona:Persona) {
    return this.http.delete<Persona>(this.Url+"/"+persona.id);
  }

}
