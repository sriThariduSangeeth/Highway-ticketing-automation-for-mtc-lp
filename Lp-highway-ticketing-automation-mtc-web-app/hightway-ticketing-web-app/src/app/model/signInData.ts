export class SignInData {
    username: string;
    password: string;

    constructor(username: string, password: string) {
        this.username = username;
        this.password = password;
    }

    get Login(): string {
        return this.username;
    }

    get Password(): string {
        return this.password;
    }
}