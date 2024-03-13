import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule } from '@angular/router';
import { UnidadeListComponent } from './unidade-list/unidade-list.component';

const unidadeRoutes: Route[] = [
  {
      path     : '',
      component: UnidadeListComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(unidadeRoutes)
  ]
})
export class UnidadeModule { }
