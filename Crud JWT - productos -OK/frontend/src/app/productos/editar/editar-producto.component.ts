import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ProductoService } from '../../services/producto.service';
import { ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-editar-producto',
  templateUrl: './editar-producto.component.html',
  styleUrls: ['./editar-producto.component.css']
})
export class EditarProductoComponent implements OnInit {

  form:  any = {};
  actualizado = false;
  failActualizado = false;
  //msjErr = '';
  //msjOK = '';
  failInit = false;

  constructor(private location:Location, private productoService:ProductoService, private router:Router, private activatedRoute: ActivatedRoute,) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.productoService.detalle(id).subscribe( data => {
      this.form.nombreProducto = data.nombreProducto;
      this.form.precio = data.precio;
    },
      (err: any) => {
        this.failInit = true;
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.productoService.editar(this.form, id)
      .subscribe( data => {
          this.actualizado = true;
          this.failActualizado = false;
          //this.msjOK = data.mensaje;          
          this.router.navigate(['lista']);
          alert("Actualizado");
    },
    (err: any) => {
      this.actualizado = false;
      this.failActualizado = true;
      //this.msjErr = err.error.mensaje;
    }
    );
  }


  volver(){
    this.location.back();
  }

}
