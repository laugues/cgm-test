/**
 * Model for user
 */
export class User {

    private _userName: string;
    private _firstName: string;
    private _lastName: string;
    private _password: string;
    private _email: string;
    private _birthday: string;
    private _roles: Array<string>;
    private _token: any;

    constructor(username: string, role: Array<string>, token: any) {
        this._userName = username;
        this._roles = role;
        this._token = token;
        this._userName = "";
        this._firstName = "";
        this._lastName = "";
        this._password = "";
        this._email = "";
        this._birthday = "";
    }

    get userName(): string {
        return this._userName;
    }

    set userName(value: string) {
        this._userName = value;
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

    get password(): string {
        return this._password;
    }

    set password(value: string) {
        this._password = value;
    }

    get email(): string {
        return this._email;
    }

    set email(value: string) {
        this._email = value;
    }

    get birthday(): string {
        return this._birthday;
    }

    set birthday(value: string) {
        this._birthday = value;
    }

    get roles(): Array<string> {
        return this._roles;
    }

    set roles(value: Array<string>) {
        this._roles = value;
    }

    get token(): any {
        return this._token;
    }

    set token(value: any) {
        this._token = value;
    }
}