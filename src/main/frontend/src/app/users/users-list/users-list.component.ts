import {Component, OnInit} from "@angular/core";

import {User} from "../users.model";
import {UserService} from "../users.service";

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss']
})
export class UsersListComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserService) {

  }

  ngOnInit() {
    // initial load of data
    this.userService.getUsers()
      .subscribe(
        (users: any[]) => {
          this.users = users
        },
        (error) => console.log(error)
      );
    // get notified when a new user has been added
    this.userService.onUserAdded.subscribe(
      (task: User) => this.users.push(task)
    );
  }
}
