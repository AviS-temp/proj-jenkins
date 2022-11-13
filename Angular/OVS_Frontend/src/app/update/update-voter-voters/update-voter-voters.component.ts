import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { RegisteredSocietyVoters } from 'src/app/model/registered-society-voters';
import { VoterServicesService } from 'src/app/services/voter-services.service';

@Component({
  selector: 'app-update-voter-voters',
  templateUrl: './update-voter-voters.component.html',
  styleUrls: ['./update-voter-voters.component.css']
})
export class UpdateVoterVotersComponent implements OnInit {
  voter:RegisteredSocietyVoters = new RegisteredSocietyVoters();
  voterIdCardNo:string;
  constructor(private service:VoterServicesService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.voterIdCardNo = this.route.snapshot.params['voterIdCardNo'];
    this.service.getVoterByVoterId(this.voterIdCardNo).subscribe(
      res=>
      {
        this.voter = res;
      },
      err=>
      {
        console.log(err);
      }
    )
  }

  updateVoter()
  {
    this.service.updateTheVoter(this.voterIdCardNo,this.voter).subscribe(
      res=>
      {
        console.log("Updated Successfully");
        alert("Update Successful");
        this.router.navigate(['/viewVotersByVoter']);
      },
      err=>
      {
        console.log("Not Updated");
      }
 
    )
  }

}
