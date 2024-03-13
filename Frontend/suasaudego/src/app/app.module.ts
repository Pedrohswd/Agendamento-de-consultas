import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ExtraOptions, PreloadAllModules, RouterModule } from '@angular/router';
import { FuseModule } from '@fuse';
import { FuseConfigModule } from '@fuse/services/config';
import { FuseMockApiModule } from '@fuse/lib/mock-api';
import { CoreModule } from 'app/core/core.module';
import { appConfig } from 'app/core/config/app.config';
import { mockApiServices } from 'app/mock-api';
import { LayoutModule } from 'app/layout/layout.module';
import { AppComponent } from 'app/app.component';
import { appRoutes } from 'app/app.routing';
import { MedicoCreateComponent } from './modules/medico/medico-create/medico-create.component';
import { MedicoListComponent } from './modules/medico/medico-list/medico-list.component';
import { MedicoUpdateComponent } from './modules/medico/medico-update/medico-update.component';
import { UnidadeCreateComponent } from './modules/unidade/unidade-create/unidade-create.component';
import { UnidadeListComponent } from './modules/unidade/unidade-list/unidade-list.component';
import { UnidadeUpdateComponent } from './modules/unidade/unidade-update/unidade-update.component';
import { FuncionarioCreateComponent } from './modules/usuario/funcionario/funcionario-create/funcionario-create.component';
import { FuncionarioListComponent } from './modules/usuario/funcionario/funcionario-list/funcionario-list.component';
import { FuncionarioUpdateComponent } from './modules/usuario/funcionario/funcionario-update/funcionario-update.component';
import { AdministradorCreateComponent } from './modules/usuario/adm/administrador-create/administrador-create.component';
import { AdministradorListComponent } from './modules/usuario/adm/administrador-list/administrador-list.component';
import { AdministradorUpdateComponent } from './modules/usuario/adm/administrador-update/administrador-update.component';

const routerConfig: ExtraOptions = {
    preloadingStrategy       : PreloadAllModules,
    scrollPositionRestoration: 'enabled'
};

@NgModule({
    declarations: [
        AppComponent,
        MedicoCreateComponent,
        MedicoListComponent,
        MedicoUpdateComponent,
        UnidadeCreateComponent,
        UnidadeListComponent,
        UnidadeUpdateComponent,
        FuncionarioCreateComponent,
        FuncionarioListComponent,
        FuncionarioUpdateComponent,
        AdministradorCreateComponent,
        AdministradorListComponent,
        AdministradorUpdateComponent
    ],
    imports     : [
        BrowserModule,
        BrowserAnimationsModule,
        RouterModule.forRoot(appRoutes, routerConfig),

        // Fuse, FuseConfig & FuseMockAPI
        FuseModule,
        FuseConfigModule.forRoot(appConfig),
        FuseMockApiModule.forRoot(mockApiServices),

        // Core module of your application
        CoreModule,

        // Layout module of your application
        LayoutModule
    ],
    bootstrap   : [
        AppComponent
    ]
})
export class AppModule
{
}
