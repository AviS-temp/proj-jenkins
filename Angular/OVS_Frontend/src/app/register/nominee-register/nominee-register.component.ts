import { Component, OnInit } from '@angular/core';
import { NominatedCandidates } from 'src/app/model/nominated-candidates';
import { RegisteredSocietyVoters } from 'src/app/model/registered-society-voters';
import { NomineeServiceService } from 'src/app/services/nominee-service.service';
import { VoterServicesService } from 'src/app/services/voter-services.service';

@Component({
  selector: 'app-nominee-register',
  templateUrl: './nominee-register.component.html',
  styleUrls: ['./nominee-register.component.css']
})
export class NomineeRegisterComponent implements OnInit {
  //society_Voter:RegisteredSocietyVoters = new RegisteredSocietyVoters();
  nominee:NominatedCandidates = new NominatedCandidates();
  voter:RegisteredSocietyVoters = new RegisteredSocietyVoters();
  id:number;
  constructor(private service:VoterServicesService, private serv:NomineeServiceService) { }

  ngOnInit(): void {
  }

  fillNominee()
  {
    this.service.login(this.voter).subscribe(
      res=>
      {
        this.nominee.nominationFormNo = res.voterIdCardNo;
        this.nominee.firstName = res.firstName;
        this.nominee.lastName = res.lastName;
        this.nominee.societyName = res.society.societyName;
        //this.society_Voter = res;
        this.id = res.id;
        //this.voter.nominatedCandidates = this.nominee;
        console.log(this.id);
        //console.log(this.nominee.society_Voter.id);
        console.log(this.nominee);
        this.serv.fillNomination(this.nominee).subscribe( // ,this.id is removed
          res=>
          {
            console.log(res);
            //this.service.updateTheVoter(this.nominee.nominationFormNo,this.voter).subscribe
          },
          err=>
          {
            console.log(err); 
          }
        )
      }
    )
  }

}
