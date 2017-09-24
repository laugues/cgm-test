import {Injectable} from '@angular/core';
import {User} from "../../models/user";
import {Http, Headers, Response, RequestOptions} from '@angular/http';
import {Observable} from "rxjs/Observable";


/**
 * Service that will stock current user
 */
@Injectable()
export class UserService {

    private _user: User;
    private USER_KEY = 'currentUser';

    constructor(private http: Http) {
        let jsonUser: any = JSON.parse(localStorage.getItem(this.USER_KEY));
        if (jsonUser != null) {
            this._user = new User(jsonUser._userName, jsonUser._roles, jsonUser._token)
        }
    }

    get user(): User {
        return this._user;
    }

    set user(value: User) {
        this._user = value;
        localStorage.setItem(this.USER_KEY, JSON.stringify(value));
    }

    /**
     * Does the current has role admin
     * @returns {boolean}
     */
    public isAdmin() {
        if (this.user != null) {
            return this.user.roles.some(roleName => roleName === "ROLE_ADMIN_ROLEADMIN")
        } else {
            return false;
        }
    }

    register(user: User) {
        return new Observable<boolean>(observer => {
            console.log('user firstName= [' + user.firstName + ']');
            let headers = new Headers({ 'Content-Type': 'application/json' });
            let options = new RequestOptions({ headers: headers });
            this.http.post('/back/users', UserService.buildBodyToSend(user), options)
                .subscribe((response: Response) => {
                        let dataResponse = response.json();
                        if (dataResponse) {
                            observer.next(true);
                        } else {
                            observer.next(false);
                        }
                        return dataResponse;
                    }, (error: any) => {
                        observer.next(false);
                        observer.complete();
                    }
                );
        });
    }

    /**
     * Build Jwt from current User
     * @returns {RequestOptions}
     */
    public jwt() {
        if (this.user && this.user.token) {
            let headers = new Headers({'Authorization': 'Bearer ' + this.user.token});
            return new RequestOptions({headers: headers});
        }
    }

    private static buildBodyToSend(user: User) {
        return JSON.stringify(
            {
                userName: user.userName,
                password: user.password,
                firstName: user.firstName,
                lastName: user.lastName,
                birthday: user.birthday,
                email: user.email
            }
        );
    }
}