import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/Modelo/Persona';
import { Location } from '@angular/common';


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  persona:Persona = new Persona();

  constructor(private router:Router, private service:ServiceService, private location:Location) { }

  ngOnInit(): void {
    this.Editar();
  }

  Editar(){
    let id = localStorage.getItem("id");
    this.service.getPersonaId(+id)
      .subscribe(data => {
        this.persona=data;
      });    
  }

  Actualizar(persona:Persona) {
    this.service.updatePersona(persona)
    .subscribe(data =>{
      this.persona = data;
      alert("Registro actualizado");
      this.router.navigate(["list"]);
    })
  }

  back(){
    this.location.back();
  }

}
