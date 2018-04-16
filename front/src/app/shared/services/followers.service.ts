import { Injectable } from '@angular/core';
import {Follower_model} from '../models/Follower_model';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import {ApiService} from "../../../shared/api.service";

@Injectable()
export class FollowersService {
  followersDay1 : Follower_model = {
    day: "Monday",
    amount: 263
  };

  followersDay2 : Follower_model;

  constructor() { //Pass API Service here
    console.log(this.followersDay1)
    // this.apiService.get("localhost:8080/api/")
  }

  getFollowersDay1(): Observable<Follower_model> {
    return of(this.followersDay1)
  }

  getFollowersDay2(): Observable<Follower_model> {
    return of(this.followersDay2)
  }



}

