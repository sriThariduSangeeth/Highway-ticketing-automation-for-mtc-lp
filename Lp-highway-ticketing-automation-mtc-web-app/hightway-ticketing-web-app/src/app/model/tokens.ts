export class Tokens {
  jwt: string;
  refreshToken: string;

  constructor(jwt: string , refreshToken: string){
      this.jwt = jwt;
      this.refreshToken = refreshToken;
  }

  getJwt():string{
    return this.jwt;
  }

  getRefreshToken(): string{
    return this.refreshToken;
  }
}
