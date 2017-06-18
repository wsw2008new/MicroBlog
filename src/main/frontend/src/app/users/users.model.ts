export class User {
	id: string;
	firstName: string;
	lastName: string;
	userName: string;

	constructor(id: string, firstName: string, lastName: string, userName: string) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}
}
