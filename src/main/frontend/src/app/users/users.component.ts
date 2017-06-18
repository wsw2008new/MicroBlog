import { Component } from '@angular/core';
import { User } from './users.model';
import { UserService } from './users.service';

@Component({
	selector: 'app-users',
	templateUrl: './users.component.html',
	styleUrls: ['./users.component.scss']
})
export class UsersComponent {

	users: User[] = [];
	userService: UserService;
	userModel: User;

	constructor(userService: UserService) {
		this.userService = userService;
		this.getUsers();
	}

	getUsers() {
		this.userService.getUsers().subscribe(
			users => this.users = users,
			err => console.error(err),
			() => console.info('%cUsers have been listed', 'color: green')
		)
	}

	addUser(user: User) {
		this.userService.addUser(user).subscribe(
			users => this.getUsers(),
			error => console.error(error)
		)
	}

	deleteUser(user: User) {
		this.userService.deleteUser(user).subscribe(
			users => this.getUsers(),
			error => console.error(error)
		)
	}
}
