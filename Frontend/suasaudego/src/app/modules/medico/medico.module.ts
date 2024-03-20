import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule } from '@angular/router';
import { MedicoListComponent } from './medico-list/medico-list.component';
import { MedicoCreateComponent } from './medico-create/medico-create.component';
import { MedicoUpdateComponent } from './medico-update/medico-update.component';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatButtonModule } from '@angular/material/button';
import { MatStepperModule } from '@angular/material/stepper';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { FuseCardModule } from '@fuse/components/card';
import { FuseAlertModule } from '@fuse/components/alert';
import { SharedModule } from 'app/shared/shared.module';
import { MatRadioModule } from '@angular/material/radio';

const medicoRoutes: Route[] = [
    {
        path     : '',
        component: MedicoListComponent
    },
    {
      path: 'cadastro',
      component: MedicoCreateComponent
    },
    {
      path:'alterar/:crm',
      component: MedicoUpdateComponent
    }
];

@NgModule({
  declarations: [
    MedicoListComponent,
    MedicoCreateComponent,
    MedicoUpdateComponent
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
    RouterModule.forChild(medicoRoutes)
  ]
})
export class MedicoModule { }
