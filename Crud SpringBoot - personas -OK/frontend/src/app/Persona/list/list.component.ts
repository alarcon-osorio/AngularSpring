import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Persona } from 'src/app/Modelo/Persona';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  personas:Persona[];

  //Referencia al servicio
  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit() {
    this.service.getPersonas()
      .subscribe(data => {
        this.personas = data;
      });
    
  }

  Editar(persona:Persona) {
    localStorage.setItem("id", persona.id.toString());
    this.router.navigate(["edit"]);
  }

  Eliminar(persona:Persona) {
    let confirmar = confirm("Esta seguro");
    if(confirmar == true) {
    this.service.deletePersona(persona)
    .subscribe(data=> {     
        this.personas= this.personas.filter(p=>p!==persona);          
    })
    }else{
      this.router.navigate(["list"]);
    }
  }
}
