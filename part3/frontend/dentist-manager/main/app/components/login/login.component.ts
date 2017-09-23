﻿import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {AuthenticationService} from '../../services/authentication.service';


@Component({
    moduleId: module.id,
    templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
    private _model: any = {
        username: "",
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
        console.log("hello from login");
        this.authenticationService.login(this._model.username, this._model.password)
            .subscribe(isUserLogged => {
                console.log('authentication result... is [' + isUserLogged + ']');
                if (isUserLogged === true) {
                    console.log('Got to dentists view');
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