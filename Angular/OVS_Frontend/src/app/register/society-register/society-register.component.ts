import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CooperativeSociety } from 'src/app/model/cooperative-society';
import { SocietyServicesService } from 'src/app/services/society-services.service';

@Component({
  selector: 'app-society-register',
  templateUrl: './society-register.component.html',
  styleUrls: ['./society-register.component.css']
})
export class SocietyRegisterComponent implements OnInit {
  society:CooperativeSociety = new CooperativeSociety();
  constructor(private service:SocietyServicesService, private router:Router) { }
  warning:string = ""; // Added Exceptions today - 11 Nov
  ngOnInit(): void {
  }

  registerSociety()
  {
    this.service.addSociety(this.society).subscribe(
      res=>
      {
        console.log(res);
        alert("Society Added");
        this.router.navigate(['/adminwelcome']);
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
