import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule } from '@angular/router';
import { AdministradorListComponent } from './usuario-list/administrador-list.component';
import { AdministradorCreateComponent } from './administrador-create/administrador-create.component';
import { AdministradorUpdateComponent } from './usuario-update/administrador-update.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatStepperModule } from '@angular/material/stepper';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatIconModule } from '@angular/material/icon';
import { FuseCardModule } from '@fuse/components/card';
import { FuseAlertModule } from '@fuse/components/alert';
import { SharedModule } from 'app/shared/shared.module';
import { MatRadioModule } from '@angular/material/radio';
import { ReactiveFormsModule } from '@angular/forms';
import { FuncionarioCreateComponent } from './funcionario-create/funcionario-create.component';

const administradorRoutes: Route[] = [
  {
    path: '',
    component: AdministradorListComponent
  },
  {
    path: 'cadastro/adm',
    component: AdministradorCreateComponent
  },
  {
    path: 'cadastro/funcionario',
    component: FuncionarioCreateComponent
  }
  ,
  {
    path: 'alterar/:id',
    component: AdministradorUpdateComponent
  }
];

@NgModule({
  declarations: [
    AdministradorListComponent,
    AdministradorCreateComponent,
    AdministradorUpdateComponent,
    FuncionarioCreateComponent
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
    SharedModule,
    MatRadioModule,
    RouterModule.forChild(administradorRoutes),
    ReactiveFormsModule
  ]
})
export class AdministradorModule { }
