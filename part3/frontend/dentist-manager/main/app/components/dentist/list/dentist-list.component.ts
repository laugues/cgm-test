import {Component, OnInit} from '@angular/core';
import {Dentist} from "../../../models/dentist";
import {Router} from "@angular/router";
import {DentistsService} from "../../../services/dentist/dentists.service";
import {CurrentDentistService} from "../../../services/dentist/current-dentist.service";

@Component({
    selector: 'dentist-list',
    templateUrl: 'dentist-list.component.html',
    styleUrls: ['dentist-list.component.css']
})

export class DentistListComponent implements OnInit {

    private _dentists: Dentist[] = [];
    private _sortProperty: string = 'name';
    private _sortDesc: boolean = false;

    constructor(private dentistService: DentistsService,
                private currentDentistService: CurrentDentistService,
                private router: Router) {
    }

    ngOnInit() {
        this.getAll();
    }

    /**
     * Get all dentists
     */
    public getAll() {
        this.dentistService.getAll()
            .subscribe(dentists => {
                this._dentists = dentists;
            });
    }

    /**
     * Select a dentist
     * @param {Dentist} selectedDentist the dentist selected
     */
    public click(selectedDentist: Dentist) {
        this.currentDentistService.dentist = selectedDentist;
        this.router.navigate(['dentist-detail']);
    }

    public sort(value: string) {
        if (value === this._sortProperty) {
            this._sortDesc = !this._sortDesc;
        }
        this._sortProperty = value;
    }


    get dentists(): Dentist[] {
        return this._dentists;
    }

    set dentists(value: Dentist[]) {
        this._dentists = value;
    }

    get sortProperty(): string {
        return this._sortProperty;
    }

    set sortProperty(value: string) {
        this._sortProperty = value;
    }

    get sortDesc(): boolean {
        return this._sortDesc;
    }

    set sortDesc(value: boolean) {
        this._sortDesc = value;
    }
}
