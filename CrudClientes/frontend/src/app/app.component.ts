import { Component } from '@angular/core';
import { ListarComponent } from './Persona/listar/listar.component';
import { NullTemplateVisitor } from '@angular/compiler';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Clientes';

constructor(private router:Router){}
  
  Listar(){
    this.router.navigate(["listar"])
  }

  Nuevo(){
    this.router.navigate(["add"])
  }

}
