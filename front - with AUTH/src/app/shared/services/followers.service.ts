import { Injectable } from '@angular/core';
import {Follower_model} from '../models/Follower_model';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import {ApiService} from '../../../shared/api.service';
import {catchError, tap} from 'rxjs/operators';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class FollowersService {
  constructor(private api: ApiService) {
  }

  private urlFollowersOne = 'localhost:8080/api/1';
  private urlFollowersTwo = 'localhost:8080/api/2';

  getFollowersDay1(): Observable<Follower_model> {
    return this.api.get<Follower_model>(this.urlFollowersOne);
  }

  getFollowersDay2(): Observable<Follower_model> {
    return this.api.get<Follower_model>(this.urlFollowersTwo);
  }



}

