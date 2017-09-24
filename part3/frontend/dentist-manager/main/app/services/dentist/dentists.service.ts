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
        return this.http.get('/back/dentists', this.userService.jwt()).map((response: Response) => response.json());
    }

}