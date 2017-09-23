import {Injectable} from "@angular/core";
import {Dentist} from "../../models/dentist";


/**
 * Current dentist service,
 * Store current selected dentist to get it in all other components
 */
@Injectable()
export class CurrentDentistService {

    private _dentist: Dentist;
    private CURRENT_DENTIST_KEY: string = "currentDentist";

    constructor() {
        let dentist: any = JSON.parse(localStorage.getItem(this.CURRENT_DENTIST_KEY));
        if (dentist != null) {
            this._dentist = new Dentist(dentist.firstName, dentist.lastName, dentist.description, dentist.imageId);
        }
    }

    get dentist(): Dentist {
        return this._dentist;
    }

    set dentist(dentist: Dentist) {
        this._dentist = dentist;
        localStorage.setItem(this.CURRENT_DENTIST_KEY, JSON.stringify(dentist));
    }
}
