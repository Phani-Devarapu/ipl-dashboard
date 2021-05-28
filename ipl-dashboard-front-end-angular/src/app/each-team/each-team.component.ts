import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { HttpService } from '../http.service';

@Component({
  selector: 'app-each-team',
  templateUrl: './each-team.component.html',
  styleUrls: ['./each-team.component.css']
})
export class EachTeamComponent implements OnInit {

  name:any;
  sub:any;
  teamPicLogo:string;
  teamData:any;
  recentMatches:any[]=[];
  color='red'

  constructor(private route:ActivatedRoute,private http_Serv:HttpService) { }

  ngOnInit() {
    this.sub = this.route.paramMap.subscribe(params => {
      this.name = params.get('teamName');
      this.teamPicLogo = "assets/" + this.name+".png"
      });

      this.loadTeamData();
      
  }

  loadTeamData()
  {
    this.http_Serv.getTeamdata(this.name).subscribe(data=>{
      

      this.teamData = data;
      this.recentMatches = this.teamData.recentMatches;
      console.log(this.recentMatches);
      console.log(this.name)


    })
  }

  

}
