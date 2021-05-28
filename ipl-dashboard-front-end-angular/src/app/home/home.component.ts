import { Component, OnInit } from "@angular/core";
import { HttpService } from "../http.service";
import { map } from "rxjs/operators";
import { Team } from "src/classes/Team";

// export interface Team {
//   id: number;
//   teamName: string;
//   totalMatches: number;
//   totalWins: number;
// }
@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  
  TeamsData: Team[] = [];
  constructor(private htpp_service: HttpService) {}

  ngOnInit() {
    this.loadteams();
  }

  loadteams() {
    this.htpp_service.getAllTeams().subscribe((data) => {
     
      this.TeamsData = data;

      this.TeamsData.forEach(e=>{
        e.teamPic ="assets/"+ e.teamName+".png";
      })
      // data.forEach((obj) => {
      //   console.log(obj);
      //   this.TeamsData.push(
      //     new Team(obj.id, obj.teamName, obj.totalMatches, obj.totalWins)
      //   );
      // });
    });

    console.log("-------------------" + " " + this.TeamsData.length);
  }
}
