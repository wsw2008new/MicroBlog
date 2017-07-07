import { Role } from 'app/users/role.model';
export class User {
	id: string;
	firstName: string;
	lastName: string;
	userName: string;
	password: string;
	email: string;
	role: Role;

	constructor(firstName: string, lastName: string, userName: string, password: string, email: string, role: Role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}
}
