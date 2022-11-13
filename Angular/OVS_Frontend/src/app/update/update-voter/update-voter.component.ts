import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegisteredSocietyVoters } from 'src/app/model/registered-society-voters';
import { VoterServicesService } from 'src/app/services/voter-services.service';

@Component({
  selector: 'app-update-voter',
  templateUrl: './update-voter.component.html',
  styleUrls: ['./update-voter.component.css']
})
export class UpdateVoterComponent implements OnInit {

  constructor(private service:VoterServicesService,private router:Router,private route:ActivatedRoute) { }
  voterIdCardNo:string;
  voter:RegisteredSocietyVoters = new RegisteredSocietyVoters();
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
        this.router.navigate(['/viewVoters']);
      },
      err=>
      {
        console.log("Not Updated");
      }
 
    )
  }


}
