import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, NgForm, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { fuseAnimations } from '@fuse/animations';
import { FuseAlertType } from '@fuse/components/alert';
import { AuthService } from 'app/core/auth/auth.service';
import { Pessoa } from 'app/models/pessoa';

@Component({
    selector     : 'auth-sign-up',
    templateUrl  : './sign-up.component.html',
    encapsulation: ViewEncapsulation.None,
    animations   : fuseAnimations
})
export class AuthSignUpComponent implements OnInit
{
    @ViewChild('signUpNgForm') signUpNgForm: NgForm;

    alert: { type: FuseAlertType; message: string } = {
        type   : 'success',
        message: ''
    };
    showAlert: boolean = false;

    pessoa: Pessoa = {
        id: '',
        nome: '',
        cpf: '',
        dataNascimento: '',
        endereco: {
            id: '',
            rua: '',
            numero: '',
            complemento: '',
            cidade: '',
            cep: ''
        }
    };

    nome: FormControl = new FormControl(null, Validators.minLength(5));

    cpf: FormControl = new FormControl(null, Validators.required);

    dataNascimento: FormControl = new FormControl(null, Validators.required);

    rua: FormControl = new FormControl(null, Validators.required);

    numero: FormControl = new FormControl(null, Validators.required);

    complemento: FormControl = new FormControl(null, Validators.required);

    cidade: FormControl = new FormControl(null, Validators.required);

    cep: FormControl = new FormControl(null, Validators.required); 

    /**
     * Constructor
     */
    constructor(
        private _authService: AuthService,
        private _router: Router
    )
    {
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void
    {
        // Create the form
        
    }

    validaCampos(): boolean {
        return this.nome.valid && this.cpf.valid
          && this.dataNascimento.valid && this.cidade.valid
          && this.rua.valid && this.cep.valid
          
      }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Sign up
     */
    signUp(): void
    {
        this._authService.signUp(this.pessoa)
            .subscribe(
                (response) => {

                    // Navigate to the confirmation required page
                    this._router.navigateByUrl('/confirmation-required');
                },
                (response) => {

                    // Re-enable the form
                    //this.signUpForm.enable();

                    // Reset the form
                    this.signUpNgForm.resetForm();

                    // Set the alert
                    this.alert = {
                        type   : 'error',
                        message: 'Something went wrong, please try again.'
                    };

                    // Show the alert
                    this.showAlert = true;
                }
            );
    }
}
