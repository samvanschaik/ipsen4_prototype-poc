import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FollowersComponent} from "./followers/followers.component";
import {LoginComponent} from "./login/login.component";
export const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'followers', component: FollowersComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class RoutesModule { }
