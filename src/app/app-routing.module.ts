import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddFatherComponent} from './add-father/add-father.component';
import {ReadFamilyComponent} from './read-family/read-family.component';

const routes: Routes = [
  {
    path: '',
    component: AddFatherComponent
  },
  {
    path: 'family',
    component: ReadFamilyComponent
  },
  {
    path: 'addfather',
    component: AddFatherComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
