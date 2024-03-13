import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule } from '@angular/router';
import { MedicoListComponent } from './medico-list/medico-list.component';

const medicoRoutes: Route[] = [
    {
        path     : 'medico',
        component: MedicoListComponent
    }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(medicoRoutes)
  ]
})
export class MedicoModule { }
