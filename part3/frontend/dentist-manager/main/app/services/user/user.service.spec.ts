/**
 * test current user service
 */

import {TestBed, inject} from "@angular/core/testing";
import {UserService} from "./user.service";
import {User} from "../../models/user";
import {HttpModule, ResponseOptions, Response, XHRBackend, ResponseType} from "@angular/http";
import {MockBackend} from "@angular/http/testing";

describe('UserService tests', () => {
    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpModule],
            providers: [UserService,
                {provide: XHRBackend, useClass: MockBackend}]
        });
    });

    it('should be truhty', inject([UserService], (service: UserService) => {
        expect(service).toBeTruthy();
    }));

    it('User should be undefined', inject([UserService], (service: UserService) => {
        expect(service.user).toBeUndefined();
    }));

    it('should be registered', inject(
        [UserService, XHRBackend],
        (service: UserService, mockBackend: MockBackend) => {
            const mockResponse = {
                data:
                    {
                        "id": 5,
                        "userName": "thePresident",
                        "firstName": "Laurent",
                        "lastName": "Blance",
                        "email": "laurent.blance@cgm.com",
                        "birthday": 31536000000,
                        "password": null
                    }
            };

            mockBackend.connections.subscribe((connection) => {
                connection.mockRespond(new Response(new ResponseOptions({
                    body: JSON.stringify(mockResponse)
                })));
            });
            service.register(new User("", [], "")).subscribe(isRegistered => {
                expect(isRegistered).toEqual(true);
            });
        }));

    it('should NOT be registered', inject(
        [UserService, XHRBackend],
        (service: UserService, mockBackend: MockBackend) => {

            mockBackend.connections.subscribe((connection) => {
                connection.mockError (new Response(new ResponseOptions({
                    body: JSON.stringify({ error: 'Internal Server Error' }),
                    status: 500,
                })));
            });
            service.register(new User("", [], "")).subscribe(isRegistered => {
                expect(isRegistered).toEqual(false);
            });
        }));
});