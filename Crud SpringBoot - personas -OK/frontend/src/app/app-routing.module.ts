import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditComponent } from './Persona/edit/edit.component';
import { ListComponent } from './Persona/list/list.component';
import { AddComponent } from './Persona/add/add.component';


const routes: Routes = [
  {path: 'list', component:ListComponent},
  {path: 'add', component:AddComponent},
  {path: 'edit', component:EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
