import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-officer-welcome',
  templateUrl: './officer-welcome.component.html',
  styleUrls: ['./officer-welcome.component.css']
})
export class OfficerWelcomeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  logout()
  {
    localStorage.removeItem("email");
    this.router.navigate(['/officer-login']);
  }

  viewVoters()
  {
    this.router.navigate(['/viewVoters']);
  }

  viewCandidates()
  {
    this.router.navigate(['/viewcandidatebyofficer']);
  }

}
