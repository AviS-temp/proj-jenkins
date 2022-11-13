import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmailDetails } from 'src/app/model/email-details';
import { RegisteredSocietyVoters } from 'src/app/model/registered-society-voters';
import { VoterServicesService } from 'src/app/services/voter-services.service';
import { ForgetPasswordService} from 'src/app/services/forget-password.service';

@Component({
  selector: 'app-voter-register',
  templateUrl: './voter-register.component.html',
  styleUrls: ['./voter-register.component.css']
})
export class VoterRegisterComponent implements OnInit {

  voter:RegisteredSocietyVoters = new RegisteredSocietyVoters();
  email:EmailDetails = new EmailDetails();
  warning:string=""; // Added Exceptions today - 11 Nov
  constructor(private service:VoterServicesService, private router:Router, private mailservice:ForgetPasswordService) { }

  ngOnInit(): void {
  }

  

  registerVoter()
  {
    //
    this.voter.voterIdCardNo = this.voter.firstName.substring(0,2).toUpperCase().concat(this.voter.lastName.substring(0,2).toUpperCase()).concat(this.voter.mobileno.substring(0,3)).concat(this.voter.pincode.toString().substring(0,3));
    this.service.register(this.voter).subscribe(
      res=>
      {
        console.log(res);
        alert("Voter Registered");
        this.email.recipient = this.voter.emailId;
        this.email.msgBody = this.voter.voterIdCardNo;
        this.email.subject = "Your Voter ID";
        this.mailservice.getPasswordUser(this.email).subscribe()
        this.router.navigate(['/voter-login']);
      },
      err=>
      {
        console.log(err);
        console.log(err.error.errorMsg);
        this.warning = err.error.errorMsg;
      }
    )
  }

}
