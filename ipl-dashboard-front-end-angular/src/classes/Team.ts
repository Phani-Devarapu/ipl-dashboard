export class Team{

    constructor( id:number,  teamName:string,  totalMatches:number,  totalWins:number)
    {
        this.id= id;
        this.teamName=teamName;
        this.totalMatches=totalMatches;
        this.totalWins=totalWins
    }


      id: number;
	  teamName:string;
	  totalMatches:number;
	  totalWins:number;

      teamPic:string
	
}