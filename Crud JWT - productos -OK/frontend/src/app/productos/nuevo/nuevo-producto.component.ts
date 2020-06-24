import { Component, OnInit } from '@angular/core';
import { Producto } from '../../models/producto';
import { ProductoService } from '../../services/producto.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-nuevo-producto',
  templateUrl: './nuevo-producto.component.html',
  styleUrls: ['./nuevo-producto.component.css']
})
export class NuevoProductoComponent implements OnInit {

  form: any = {};
  producto: Producto;
  creado = false;
  failProducto = false;
  mensajeFail = '';
  mensajeOK = '';

  constructor(private productoService: ProductoService, private router: Router, private location: Location) { }

  ngOnInit() {
  }

  onCreate(): void {
    this.productoService.crear(this.form)
    .subscribe(data => {
      //this.mensajeOK = data.mensaje;
      this.creado = true;           
      this.failProducto = false;
      this.router.navigate(['lista']);
      alert("Registro Creado");
    },
      (err: any) => {
        //this.mensajeFail = err.error.mensaje;
        this.creado = false;                
        this.failProducto = true;
      }
    );
  }

  volver(): void {
    this.location.back();
  }
}
