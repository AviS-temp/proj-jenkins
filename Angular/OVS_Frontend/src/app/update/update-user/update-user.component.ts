import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  user:User = new User();
  userId:number;
  constructor(private service:UserServiceService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['userId'];
    this.service.getUserById(this.userId).subscribe(
      res=>
      {
        this.user = res;
      }, error => console.log(error));
  }

  updateUser()
  {
    this.service.updateUser(this.userId,this.user).subscribe
    (
      res=>
      {
        this.goToUsers();
      },
      error=>console.log(error));
  }

  goToUsers()
  {
    this.router.navigate(['/viewUsers']);
  }

}
