export class User {
    id: number;
    username: string;
    firstName: string;
    lastName: string;
    token?: string;

    constructor(id: number, username: string, firstName: string, lastName: string ,token?: string){

        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = token;
    }
}