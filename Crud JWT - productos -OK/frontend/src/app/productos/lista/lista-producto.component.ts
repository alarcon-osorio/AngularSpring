import { Component, OnInit, Input} from '@angular/core';
import { ProductoService } from '../../services/producto.service';
import { Producto } from '../../models/producto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-producto',
  templateUrl: './lista-producto.component.html',
  styleUrls: ['./lista-producto.component.css']
})
export class ListaProductoComponent implements OnInit {

  @Input() user: string;

  productos: Producto[] = [];

  constructor(private productoService: ProductoService, private router:Router) { }

  ngOnInit(): void {
    this.cargarProductos();
  }

  cargarProductos(): void {
    this.productoService.lista()
      .subscribe(data=>{
        this.productos = data;
      },
      (err: any) => {
        console.log(err);
      });
  }

  onDelete(id: number): void {
    let confirmar = confirm("Esta seguro");
    if(confirmar == true) {
      this.productoService.borrar(id)
        .subscribe(data=> {     
          this.cargarProductos();            
      })
    }    
  }
}

