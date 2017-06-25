import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { UserService } from 'app/users/users.service';

@Injectable()
export class UserResolver implements Resolve<void> {
	constructor(private userService: UserService) {
	}

	resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
		return this.userService.getUsers();
	}
}
