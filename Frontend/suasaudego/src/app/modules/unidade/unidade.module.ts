import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule } from '@angular/router';
import { UnidadeListComponent } from './unidade-list/unidade-list.component';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatButtonModule } from '@angular/material/button';
import { UnidadeCreateComponent } from './unidade-create/unidade-create.component';
import { UnidadeUpdateComponent } from './unidade-update/unidade-update.component';
import { MatStepperModule } from '@angular/material/stepper';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { FuseCardModule } from '@fuse/components/card';
import { FuseAlertModule } from '@fuse/components/alert';
import { SharedModule } from 'app/shared/shared.module';
import { MatRadioModule } from '@angular/material/radio';

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
    path: 'alterar/:cnes',
    component: UnidadeUpdateComponent
  }
];

@NgModule({
  declarations: [
    UnidadeListComponent,
    UnidadeCreateComponent,
    UnidadeUpdateComponent
  ],
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    MatStepperModule,
    MatCheckboxModule,
    MatIconModule,
    MatProgressSpinnerModule,
    FuseCardModule,
    FuseAlertModule,
    SharedModule,
    MatRadioModule,
    RouterModule.forChild(unidadeRoutes)
  ]
})
export class UnidadeModule { }
