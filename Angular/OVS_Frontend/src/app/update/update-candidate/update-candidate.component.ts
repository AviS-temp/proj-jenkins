import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { NominatedCandidates } from 'src/app/model/nominated-candidates';
import { RegisteredSocietyVoters } from 'src/app/model/registered-society-voters';
import { NomineeServiceService } from 'src/app/services/nominee-service.service';

@Component({
  selector: 'app-update-candidate',
  templateUrl: './update-candidate.component.html',
  styleUrls: ['./update-candidate.component.css']
})
export class UpdateCandidateComponent implements OnInit {
  candidate:NominatedCandidates = new NominatedCandidates();
  society_Voter:RegisteredSocietyVoters = new RegisteredSocietyVoters();
  candidateId:number;
  warning:string="";
  constructor(private router:Router,private route:ActivatedRoute, private service:NomineeServiceService) { }

  ngOnInit(): void {
    this.candidateId = this.route.snapshot.params['candidateId'];
    this.service.getCandidateById(this.candidateId).subscribe(
      res=>
      {
        this.candidate = res;
      }
    )
  }

  updateCandidate()
  {
    this.service.updateCandidate(this.candidateId,this.candidate).subscribe(
      res=>
      {
        alert("Updated Successfully");
        this.goToCandidates();
        
      },
      err=>
      {
        console.log(err);
      }
    )
  }

  goToCandidates()
  {
    this.router.navigate(['/viewCandidates']);
  }

}
