import { Input, Component, Output, EventEmitter, ViewChild, ElementRef, OnInit } from '@angular/core';
import { first, map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { FormGroup, FormControl } from '@angular/forms';
import { SignInData } from '../model/signInData';
import { AuthService } from '../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  /** Based on the screen size, switch from standard to one column per row */


  emailId: string = '';
  passwordId: string = '';
  error:string = '';
  returnUrl: string = '';
  loading: boolean = false;
  public signInData!: SignInData;

  constructor(private breakpointObserver: BreakpointObserver, private authService: AuthService, private route: ActivatedRoute,
    private router: Router) {
    // redirect to main if already exsisting token in local storage
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/main']);
    }
  }
  ngOnInit(): void {

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/main';
  }

  public submitLogin(): void {
    this.signInData = new SignInData(this.emailId, this.passwordId);

    this.loading = true;
    this.authService.login(this.signInData).subscribe(
      success => {
        this.router.navigate([this.returnUrl]);
        this.loading = false;
      },
      error => {
        this.error = error;
        this.loading = false;
      }
    );

  }
}
