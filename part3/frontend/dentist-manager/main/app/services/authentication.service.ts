import {Injectable} from '@angular/core';
import {Http, Headers, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import {JwtHelper} from "angular2-jwt";
import {UserService} from "./user/user.service";
import {User} from "../models/user";

@Injectable()
export class AuthenticationService {


    constructor(private http: Http, private userService: UserService) {
    }

    login(username: string, password: string) {
        return new Observable<boolean>(observer => {
            this.http.post('/back/login', JSON.stringify({userName: username, password: password}))
                .subscribe((response: Response) => {
                        let dataResponse = response.json();
                        if (dataResponse && dataResponse.token) {
                            let decodeToken = AuthenticationService.decodeToken(dataResponse);
                            this.userService.user = new User(username, JSON.parse(decodeToken.roles), dataResponse.token);
                            observer.next(true);
                        } else {
                            observer.next(false);
                        }
                        return dataResponse;
                    }, (error: any) => {
                        if (error.status == 401) {
                            console.log("401 unauthorized");
                            //Set to false in order to tell the login failed
                            observer.next(false);
                            observer.complete();
                        }
                    }
                );
        });


    }

    /**
     * Decode the token from data reponse
     * @param dataResponse
     * @returns {any} the token decode
     */
    private static decodeToken(dataResponse: any) {
        let jwtHelper: JwtHelper = new JwtHelper();
        return jwtHelper.decodeToken(dataResponse.token);
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}