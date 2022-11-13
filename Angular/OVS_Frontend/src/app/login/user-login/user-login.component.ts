import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  user:User = new User();
  warning:string = "";
  //November 8
  //Always declare private
  constructor(private service:UserServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  loginUser()
  {
    this.service.login(this.user).subscribe(
      res=>
      {
        console.log("Logged In");
        localStorage.setItem("email",this.user.email);
        this.router.navigate(['/userwelcome']);
      },
      err=>
      {
        console.log("Not Logged In");
        this.warning = err.error.errorMsg;
      }
    )
  }

}
