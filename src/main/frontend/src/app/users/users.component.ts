import { Component, OnInit } from '@angular/core';
import { User } from './users.model';
import { UserService } from './users.service';
import { environment } from 'environments/environment.prod';

@Component({
	selector: 'app-users',
	templateUrl: './users.component.html',
	styleUrls: ['./users.component.scss'],
	providers: [User]
})
export class UsersComponent implements OnInit {

	users: User[] = [];
	userService: UserService;
	userModel: User;

	constructor(userService: UserService, userModel: User) {
		this.userService = userService;
		this.userModel = userModel;
	}

	ngOnInit() {
		this.getUsers();
	}

	getUsers() {
		this.userService.getUsers().subscribe(
			users => {this.users = users},
			err => console.error(err),
			() => console.info('%cUsers have been listed', 'color: green')
		);
	}

	submitForm(user: User) {
		this.userService.addUser(user).subscribe();
		location.reload();
	}
}
