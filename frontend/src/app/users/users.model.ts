import { Role } from 'app/users/roles.model';
export class User {
	id: string;
	firstName: string;
	lastName: string;
	userName: string;
	password: string;
	role: Role;

	constructor(firstName: string, lastName: string, userName: string, password: string, role: Role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
}
