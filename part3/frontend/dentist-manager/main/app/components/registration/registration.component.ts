import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {User} from "../../models/user";
import {UserService} from "../../services/user/user.service";

@Component({
    selector: 'registration',
    templateUrl: 'registration.component.html',
    styleUrls: ['registration.component.css']
})

export class RegistrationComponent implements OnInit {

    private _user: User = new User("", [], "");
    private _minDate: Date;
    private _error: string = "";

    constructor(private router: Router, private userService: UserService) {
        let today: Date = new Date();
        let minAge: number = 18;
        this._minDate = new Date(today.getFullYear() - minAge, today.getMonth(), today.getDate());
    }

    ngOnInit() {

    }


    public register() {
        this.userService.register(this.user)
            .subscribe(isUserRegistered => {
                if (isUserRegistered === true) {
                    this.router.navigate(['login']);
                } else {
                    this._error = 'Registration failed';
                }
            });
    }


    get user(): User {
        return this._user;
    }

    set user(value: User) {
        this._user = value;
    }


    get error(): string {
        return this._error;
    }

    set error(value: string) {
        this._error = value;
    }
}
