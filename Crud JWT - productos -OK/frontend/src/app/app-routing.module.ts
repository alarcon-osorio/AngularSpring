import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './productos/home/home.component';
import { ListaProductoComponent } from './productos/lista/lista-producto.component';
import { DetalleProductoComponent } from './productos/detalle/detalle-producto.component';
import { NuevoProductoComponent } from './productos/nuevo/nuevo-producto.component';
import { EditarProductoComponent } from './productos/editar/editar-producto.component';
import { LoginComponent } from './auth/login/login.component';
import { GuardService as guard} from './guards/guard.service';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'lista', component: ListaProductoComponent},

  // productos: utilizamos canActivate
  {path: 'detalle/:id', component: DetalleProductoComponent,
  canActivate: [guard], data: { expectedRol: ['admin', 'user']}},
  {path: 'nuevo', component: NuevoProductoComponent,
  canActivate: [guard], data: { expectedRol: ['admin']}},
  {path: 'editar/:id', component: EditarProductoComponent,
  canActivate: [guard], data: { expectedRol: ['admin']}},

  // rutas a login y registro
  {path: 'login', component: LoginComponent},
  {path: '**', redirectTo: 'home', pathMatch: 'full'}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
