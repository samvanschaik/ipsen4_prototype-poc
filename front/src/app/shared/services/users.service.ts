import { Injectable } from '@angular/core';
import {ApiService} from "../../../shared/api.service";
import {User} from "../models/User.model";
import {Observable} from "rxjs/Observable";
import {Router} from "@angular/router";
import {LoginService} from "./login.service";

@Injectable()
export class UsersService {

  constructor(private api: ApiService,
              private loginService: LoginService,
              private router: Router) {

  }

  public getAll(): Observable<User[]> {
    return this.api.get<User[]>('employee');
  }

  public login(user: User, remember: boolean): void {
    this.loginService.setAuthorization(user.name, user.password);

    this.api.get<User>('employee/login').subscribe(
      authenticator => {
        this.loginService.storeAuthorization(authenticator, remember);
        this.goToTimeSheet();
      },
      error => {
        alert('Het inloggen is mislukt');
      }
    );
  }

  public logout() {
    this.authService.deleteAuthorization();

    this.goToLogin();
  }
}
