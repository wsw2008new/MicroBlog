import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions } from '@angular/http';
import { User } from 'app/users/users.model';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {
	private headers = new Headers({'Content-Type': 'application/json'});
	private options = new RequestOptions({headers: this.headers});

	constructor(private http: Http) {
	}

	getUsers() {
		const url = '/api/users/all';
		return this.http.get(url).map(response => response.json());
	}

	addUser(user: User) {
		const body = JSON.stringify(user);

		const url = '/api/users/insert';
		return this.http.post(url, body, this.options);
	}

	deleteUser(user: User) {
		const body = JSON.stringify(user);

		const url = '/api/users/delete';
		return this.http.delete(url, new RequestOptions({
			headers: this.headers,
			body
		}));
	}
}
