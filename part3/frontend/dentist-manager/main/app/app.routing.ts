/**
 * Route configuration for app
 */
import {Routes, RouterModule} from "@angular/router";
import {AuthGuard} from "./guards/auth.guard";
import {LoginComponent} from "./components/login/login.component";
import {DentistHomeComponent} from "./components/dentist/home/dentist-home.component";
import {DentistDetailComponent} from "./components/dentist/detail/dentist-detail.component";
import {RegistrationComponent} from "./components/registration/registration.component";


const appRoutes: Routes = [
    {path: '', component: LoginComponent},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegistrationComponent},
    {path: 'dentists', component: DentistHomeComponent, canActivate: [AuthGuard]},
    {path: 'dentist-detail', component: DentistDetailComponent, canActivate: [AuthGuard]},
    // otherwise redirect to home
    {path: '**', redirectTo: ''}
];

export const routing = RouterModule.forRoot(appRoutes);
