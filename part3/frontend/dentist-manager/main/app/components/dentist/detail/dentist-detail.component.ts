import {Component, OnInit} from '@angular/core';
import {Dentist} from "../../../models/dentist";

import {Router} from "@angular/router";

import {CurrentDentistService} from "../../../services/dentist/current-dentist.service";

@Component({
    selector: 'dentist-detail',
    templateUrl: 'dentist-detail.component.html',
    styleUrls: ['dentist-detail.component.css']
})

export class DentistDetailComponent implements OnInit {

    private _dentist: Dentist;
    private _expande: boolean = false;

    constructor(private currentDentistService: CurrentDentistService,
                private router: Router) {
    }

    ngOnInit() {
        // reset login status
        this._dentist = this.currentDentistService.dentist;
        if (!this.dentistIsValid()) {
            this.router.navigate(['dentists']);
        }
    }

    private dentistIsValid() {
        return this._dentist != null && this._dentist.firstName && this._dentist.lastName;
    }

    get dentist(): Dentist {
        return this._dentist;
    }

    set dentist(value: Dentist) {
        this._dentist = value;
    }


    get expande(): boolean {
        return this._expande;
    }

    set expande(value: boolean) {
        this._expande = value;
    }
}
