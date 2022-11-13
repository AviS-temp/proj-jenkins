import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ElectionOfficer } from 'src/app/model/election-officer';
import { OfficerServicesService } from 'src/app/services/officer-services.service';

@Component({
  selector: 'app-officer-login',
  templateUrl: './officer-login.component.html',
  styleUrls: ['./officer-login.component.css']
})
export class OfficerLoginComponent implements OnInit {
  officer:ElectionOfficer=new ElectionOfficer();
  warning:string = ""; // Added Exceptions Today - 11 Nov
  constructor(private service:OfficerServicesService, private router:Router) { }

  ngOnInit(): void {
  }

  loginOfficer()
  {
    this.service.login(this.officer).subscribe(
      res=>
      {
        console.log("Logged In");
        localStorage.setItem("email",this.officer.emailId);
        this.router.navigate(['/officer-welcome']);
      },
      err=>
      {
        console.log("Not Logged In");
        console.log(err.error.errorMsg);
        this.warning = err.error.errorMsg;
      }
      
    )

  }

}
