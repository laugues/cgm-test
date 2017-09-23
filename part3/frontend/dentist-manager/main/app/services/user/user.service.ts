import {Injectable} from '@angular/core';
import {User} from "../../models/user";


/**
 * Service that will stock current user
 */
@Injectable()
export class UserService {

    private _user: User;
    private USER_KEY = 'currentUser';

    constructor() {
        let jsonUser: any = JSON.parse(localStorage.getItem(this.USER_KEY));
        if (jsonUser != null) {
            this._user = new User(jsonUser._username, jsonUser._roles, jsonUser._token)
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

}