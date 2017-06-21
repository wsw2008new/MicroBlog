import { Component, OnInit } from '@angular/core';
import { User } from './users.model';
import { UserService } from './users.service';
import { NgForm } from '@angular/forms';

@Component({
	selector: 'app-users',
	templateUrl: './users.component.html',
	styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

	users: User[] = [];

	constructor(private userService: UserService) {
	}

	ngOnInit() {
		this.getUsers();
	}

	getUsers() {
		this.userService.getUsers().subscribe(
			users => this.users = users,
			err => console.error(err),
			() => console.info('%cUsers have been listed', 'color: green')
		);
	}

	addUser(form: NgForm) {
		this.userService.addUser(form.value).subscribe(
			users => this.getUsers(),
			error => console.error(error)
		);
	}

	deleteUser(user: User) {
		this.userService.deleteUser(user).subscribe(
			users => this.getUsers(),
			error => console.error(error)
		);
	}
}
