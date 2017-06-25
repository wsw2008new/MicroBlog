import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from './users.model';
import { UserService } from './users.service';

@Component({
	selector: 'app-users',
	templateUrl: './users.component.html'
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
			data => this.users = data,
			err => console.error(err),
			() => console.info('%cUsers have been listed', 'color: green')
		);
	}

	addUser(form: NgForm) {
		this.userService.addUser(form.value).subscribe(
			() => this.userService.getUsers().subscribe(
				data => this.users = data,
				err => console.error(err)
			)
		);
		form.reset()
	}

	deleteUser(user: User) {
		this.userService.deleteUser(user).subscribe(
			() => this.userService.getUsers().subscribe(
				data => this.users = data,
				err => console.error(err)
			)
		)
		;
	}
}
