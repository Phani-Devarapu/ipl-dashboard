import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EachTeamComponent } from './each-team/each-team.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path:'eachTeam/:teamName', component:EachTeamComponent},
  {path:'**', component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
