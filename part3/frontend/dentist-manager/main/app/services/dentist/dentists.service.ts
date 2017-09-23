import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions, Response} from '@angular/http';

import {Observable} from "rxjs/Observable";
import {UserService} from "../user/user.service";
import {Dentist} from "../../models/dentist";

@Injectable()
export class DentistsService {


    constructor(private http: Http, private userService: UserService) {
    }

    getAll(): Observable<Dentist[]> {
        return this.http.get('/back/dentists', this.jwt()).map((response: Response) => response.json());
    }


    /**
     * Build Jwt from current User
     * @returns {RequestOptions}
     */
    private jwt() {
        if (this.userService.user && this.userService.user.token) {
            let headers = new Headers({'Authorization': 'Bearer ' + this.userService.user.token});
            return new RequestOptions({headers: headers});
        }
    }
}