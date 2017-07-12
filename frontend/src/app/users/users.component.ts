import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from './users.model';
import { UserService } from './users.service';

@Component({
	selector: 'app-users',
	templateUrl: './users.component.html'
})
export class UsersComponent implements OnInit {

	signUpForm: FormGroup;
	users: User[] = [];

	constructor(private userService: UserService) {
	}

	ngOnInit() {
		this.signUpForm = new FormGroup({
			'userName': new FormControl(null, Validators.required),
			'email': new FormControl(null, [Validators.required, Validators.email]),
			'firstName': new FormControl(null, Validators.required),
			'lastName': new FormControl(null, Validators.required),
			'password': new FormControl(null, Validators.required),
			'role': new FormGroup({
				'roleName': new FormControl('user')
			})
		});
		this.getUsers();
	}

	getUsers() {
		this.userService.getUsers().subscribe(
			data => this.users = data,
			err => console.error(err),
			() => console.info('%cUsers have been listed', 'color: green')
		);
	}

	addUser() {
		console.log(this.signUpForm.value);
		this.userService.addUser(this.signUpForm.value).subscribe(
			data => this.getUsers(),
			err => console.error(err)
		);
		this.signUpForm.reset();
	}

	deleteUser(user: User) {
		this.userService.deleteUser(user).subscribe(
			data => this.getUsers(),
			err => console.error(err)
		);
	}
}
