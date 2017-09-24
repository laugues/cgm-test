import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {AuthenticationService} from '../../services/authentication.service';


@Component({
    moduleId: module.id,
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.css']
})

export class LoginComponent implements OnInit {
    private _model: any = {
        userName: "",
        password: ""
    };
    private _loading = false;
    /**
     * Error message
     * @type {string}
     * @private
     */
    private _error = '';

    constructor(private route: ActivatedRoute,
                private router: Router,
                private authenticationService: AuthenticationService) {
    }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();
    }

    login() {
        this._loading = true;
        this.authenticationService.login(this._model.userName, this._model.password)
            .subscribe(isUserLogged => {
                if (isUserLogged === true) {
                    this.router.navigate(['dentists']);
                } else {
                    this._error = 'Username or password is incorrect';
                    this._loading = false;
                }
            });
    }


    get model(): any {
        return this._model;
    }

    set model(value: any) {
        this._model = value;
    }

    get loading(): boolean {
        return this._loading;
    }

    set loading(value: boolean) {
        this._loading = value;
    }

    get error(): string {
        return this._error;
    }

    set error(value: string) {
        this._error = value;
    }
}
