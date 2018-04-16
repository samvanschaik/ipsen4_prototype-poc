import { Component, OnInit } from '@angular/core';
import {User} from '../shared/models/User.model';
import {UsersService} from "../shared/services/users.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UsersService) { }

  ngOnInit() {
  }

  public login() {
    this.userService.login(this.user, false);
  }
}
