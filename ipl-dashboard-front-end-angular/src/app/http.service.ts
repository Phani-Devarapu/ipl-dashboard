import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from 'src/classes/Team';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpClient: HttpClient) { }

  getAllTeams():Observable<Team[]>
  {
    return this.httpClient.get<Team[]>("http://localhost:8080/teams");
  }

  getTeamdata(teamName : String)
  {
    
    const path = "http://localhost:8080/team/"+ teamName;
    console.log("in the service " + path)
    return this.httpClient.get(path);
  }
}
