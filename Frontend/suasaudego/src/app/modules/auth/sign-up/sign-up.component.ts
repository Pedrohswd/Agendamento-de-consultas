import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, NgForm, Validators, FormControl, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { fuseAnimations } from '@fuse/animations';
import { FuseAlertType } from '@fuse/components/alert';
import { AuthService } from 'app/core/auth/auth.service';
import { Pessoa } from 'app/models/pessoa';
import { Usuario } from 'app/models/usuario';

@Component({
    selector: 'auth-sign-up',
    templateUrl: './sign-up.component.html',
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class AuthSignUpComponent implements OnInit {
    @ViewChild('signUpNgForm') signUpNgForm: NgForm;

    alert: { type: FuseAlertType; message: string } = {
        type: 'success',
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


    usuario: Usuario = {
        id: '',
        email: '',
        senha: '',
        cnes: null,
        pessoa: '',
        perfil: 1
    }

    email: FormControl = new FormControl(null, Validators.email);
    senha: FormControl = new FormControl(null, Validators.minLength(3));


    firstFormGroup = this._formBuilder.group({
        firstCtrl: ['', Validators.required],
      });
      secondFormGroup = this._formBuilder.group({
        secondCtrl: ['', Validators.required],
      });
      isLinear = false;

    /**
     * Constructor
     */
    constructor(
        private _authService: AuthService,
        private _router: Router,
        private _formBuilder: FormBuilder
    ) {
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void {
        // Create the form

    }

    validaCampos(): boolean {
        return this.nome.valid && this.cpf.valid
            && this.dataNascimento.valid && this.cidade.valid
            && this.rua.valid && this.cep.valid
            && this.email.valid && this.senha.valid
    }


    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Sign up
     */

    signUp(): void {
        this._authService.signUp(this.pessoa)
            .subscribe(
                (response) => {
                    this._authService.signUpUser(this.usuario).subscribe((response)=>{

                    },
                    (response) =>{

                        // Re-enable the form
                        //this.signUpForm.enable();

                        // Reset the form
                        this.signUpNgForm.resetForm();

                        // Set the alert
                        this.alert = {
                            type: 'error',
                            message: 'Something went wrong, please try again.'
                        };

                        // Show the alert
                        this.showAlert = true;
                    }
                    );

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
                        type: 'error',
                        message: 'Something went wrong, please try again.'
                    };

                    // Show the alert
                    this.showAlert = true;
                }
            );
    }
}
