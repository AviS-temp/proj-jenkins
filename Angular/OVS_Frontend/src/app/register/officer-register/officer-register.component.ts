import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ElectionOfficer } from 'src/app/model/election-officer';
import { OfficerServicesService } from 'src/app/services/officer-services.service';

@Component({
  selector: 'app-officer-register',
  templateUrl: './officer-register.component.html',
  styleUrls: ['./officer-register.component.css']
})
export class OfficerRegisterComponent implements OnInit {
  officer:ElectionOfficer = new ElectionOfficer();
  warning:string = ""; // Added Exceptions today - 11 Nov
  constructor(private service:OfficerServicesService, private router:Router) { }

  ngOnInit(): void {
  }

  registerOfficer()
  {
    this.service.addOfficer(this.officer).subscribe(
      res=>
      {
        console.log(res);
        this.router.navigate(['/officer-welcome']);
      },
      err=>
      {
        console.log(err.error.errorMsg);
        this.warning = err.error.errorMsg;
      }
    )
  }

}
