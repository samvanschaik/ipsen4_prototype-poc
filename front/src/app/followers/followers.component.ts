import { Component, OnInit } from '@angular/core';
import {FollowersService} from "../shared/services/followers.service";
import {Follower_model} from "../shared/models/Follower_model";
import {log} from "util";

@Component({
  selector: 'app-followers',
  templateUrl: './followers.component.html',
  styleUrls: ['./followers.component.css']
})
export class FollowersComponent implements OnInit {
  followersDay1 : Follower_model;
  followersDay2 : Follower_model;

  constructor(private followerservice: FollowersService) {}

  ngOnInit() {
    this.getFollowersDay1();
    this.getFollowersDay2();

  }

  getFollowersDay1(): void {
    this.followerservice.getFollowersDay1()
      .subscribe(followersDay1 => this.followersDay1 = followersDay1)
  }

  getFollowersDay2(): void {
    this.followerservice.getFollowersDay2()
      .subscribe(followersDay2 => this.followersDay2 = followersDay2)
  }


}
