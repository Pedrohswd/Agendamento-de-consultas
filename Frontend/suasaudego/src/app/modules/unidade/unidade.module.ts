import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule } from '@angular/router';
import { UnidadeListComponent } from './unidade-list/unidade-list.component';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatButtonModule} from '@angular/material/button';
import { UnidadeCreateComponent } from './unidade-create/unidade-create.component';
import { UnidadeUpdateComponent } from './unidade-update/unidade-update.component';

const unidadeRoutes: Route[] = [
  {
    path: '',
    component: UnidadeListComponent
  },
  {
    path: 'cadastro',
    component: UnidadeCreateComponent
  },
  {
    path: 'alterar',
    component: UnidadeUpdateComponent
  }
];

@NgModule({
  declarations: [
    UnidadeListComponent
  ],
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    RouterModule.forChild(unidadeRoutes)
  ]
})
export class UnidadeModule { }
