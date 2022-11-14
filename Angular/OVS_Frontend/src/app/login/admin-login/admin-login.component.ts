import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  user: User = new User();
  warning: string = "";
  constructor(private service: UserServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  loginAdmin() {
    if ((this.user.email == "abhisheksamantaray73bbsr@gmail.com" && this.user.password == "Avi")
      ||
      (this.user.email == "ankita101420@gmail.com" && this.user.password == "chiko")
      ||
      (this.user.email == "suyogshembale@gmail.com" && this.user.password == "suyog21")
      ||
      (this.user.email == "khushalswami30@gmail.com" && this.user.password == "kks")
      ||
      (this.user.email == "saurabhjan14@gmail.com" && this.user.password == "saur")) {
      this.service.login(this.user).subscribe(
        res => {
          console.log("Logged In");
          localStorage.setItem("email", this.user.email);
          this.router.navigate(['/adminwelcome']);
        },
        err => {
          console.log("Not Logged In");
        }
      )
    }
    else {
      // alert("Not An Admin");
      this.warning = "Admin Authentication Failed";
    }
  }

}
