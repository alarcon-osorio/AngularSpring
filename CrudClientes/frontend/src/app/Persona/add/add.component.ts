import { Component, OnInit, HostBinding } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/Modelo/Persona';
import { Location } from '@angular/common';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  @HostBinding('class') classes = 'row';

  persona:Persona = {
    id: 0,
    nombre: '',
    apellidos: ''
  };

 constructor(private router:Router, private service:ServiceService, private location:Location) { }

  ngOnInit() {
    
  }

  Guardar() {    
    this.service.createPersona(this.persona)
    .subscribe(data=> {
        //console.log(data);
        console.log("Agregado correctamnete");
        this.router.navigate(["/listar"]);
      },
      err => console.error(err)
    ) 
  }

  back() {
    this.location.back();
  }
}