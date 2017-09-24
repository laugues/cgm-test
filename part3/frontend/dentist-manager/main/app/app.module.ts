import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

// used to create fake backend
import {BaseRequestOptions} from '@angular/http';

import {AppComponent} from './app.component';
import {routing} from './app.routing';

import {AuthGuard} from './guards/auth.guard';
import {AlertService} from './services/alert.service';
import {AuthenticationService} from './services/authentication.service';

import {LoginComponent} from './components/login';
import {DentistListComponent} from "./components/dentist/list/dentist-list.component";

import {UserService} from "./services/user/user.service";
import {OrderModule} from "ngx-order-pipe";
import {DentistDetailComponent} from "./components/dentist/detail/dentist-detail.component";
import {DentistsService} from "./services/dentist/dentists.service";
import {CurrentDentistService} from "./services/dentist/current-dentist.service";
import {DentistHomeComponent} from "./components/dentist/home/dentist-home.component";
import {RegistrationComponent} from "./components/registration/registration.component";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        OrderModule,
        routing
    ],
    declarations: [
        AppComponent,
        LoginComponent,
        DentistHomeComponent,
        DentistListComponent,
        DentistDetailComponent,
        RegistrationComponent
    ],
    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        DentistsService,
        CurrentDentistService,
        UserService,
        BaseRequestOptions
    ],
    bootstrap: [AppComponent]
})

export class AppModule {
}