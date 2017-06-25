import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'app/users/users.service';
@Component({
	selector: 'app-users-add',
	templateUrl: 'users-add.component.html'
})
export class UsersAddComponent {

	constructor(private userService: UserService, private router: Router) {
	}

	addUser(form: NgForm) {
		this.userService.addUser(form.value).subscribe(
			users => this.userService.getUsers(),
			error => console.error(error)
		);
		this.router.navigate(['/users']);
	}
}