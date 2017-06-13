import { Component, OnInit } from "@angular/core";
import { User } from "./users.model";
import { UserService } from "./users.service";

@Component({
	selector: 'app-users',
	templateUrl: './users.component.html',
	styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

	users: User[] = [];
	private userService: UserService;

	constructor(userService: UserService) {
		this.userService = userService;
	}

	ngOnInit() {
		this.userService.getUsers().subscribe((users: any[]) => this.users = users);
	}
}
