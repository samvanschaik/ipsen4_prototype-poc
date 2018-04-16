import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { FollowersComponent } from './followers/followers.component';
import { FollowersService } from './followers.service';


@NgModule({
  declarations: [
    AppComponent,
    FollowersComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [FollowersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
