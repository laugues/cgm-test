/**
 * Model for dentist
 */
export class Dentist {

    private _firstName: string;
    private _lastName: string;
    private _description: string;
    private _imageId: number;


    constructor(name: string, number: string, description: string, _imageId: number) {
        this._firstName = name;
        this._lastName = number;
        this._description = description;
        this._imageId = _imageId;
    }


    get firstName(): string {
        return this._firstName;
    }

    set firstName(value: string) {
        this._firstName = value;
    }

    get lastName(): string {
        return this._lastName;
    }

    set lastName(value: string) {
        this._lastName = value;
    }


    get description(): string {
        return this._description;
    }

    set description(value: string) {
        this._description = value;
    }


    get imageId(): number {
        return this._imageId;
    }

    set imageId(value: number) {
        this._imageId = value;
    }
}