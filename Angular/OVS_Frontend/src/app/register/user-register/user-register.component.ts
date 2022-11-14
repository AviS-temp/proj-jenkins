import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {
  user:User = new User();
  warning:string=""; // Added Exceptions today - 11 Nov
  success_msg:string=""; // 13 Nov

  constructor(private service:UserServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  registerUser()
  {
    this.service.register(this.user).subscribe(
      res=>
      {
        console.log(res);
        //alert("User Registered");
        this.success_msg = "Registration Successful";
        setTimeout(()=>
        {this.router.navigate(['/user-login']);},3000)
        
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
