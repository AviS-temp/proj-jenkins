import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CooperativeSociety } from 'src/app/model/cooperative-society';
import { RegisteredSocietyVoters } from 'src/app/model/registered-society-voters';
import { SocietyServicesService } from 'src/app/services/society-services.service';

@Component({
  selector: 'app-update-society',
  templateUrl: './update-society.component.html',
  styleUrls: ['./update-society.component.css']
})
export class UpdateSocietyComponent implements OnInit {
  society:CooperativeSociety = new CooperativeSociety();
  societyId:number;
  constructor(private service:SocietyServicesService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.societyId = this.route.snapshot.params['societyId'];
    this.service.getSocietyById(this.societyId).subscribe(
      res=>
      {
        this.society = res;
      }, error => console.log(error));
  }

  updateSociety()
  {
    this.service.updateSociety(this.societyId,this.society).subscribe
    (
      res=>
      {
        this.goToSocieties();
      },
      error=>console.log(error));
  }

  goToSocieties()
  {
    this.router.navigate(['/viewSocieties']);
  }

}
