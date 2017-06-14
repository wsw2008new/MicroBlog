import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions } from '@angular/http';
import { User } from 'app/users/users.model';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {

	private http: Http;

	constructor(http: Http) {
		this.http = http;
	}

	getUsers() {
		let url = '/api/users/all';
		return this.http.get(url).map(response => response.json());
	}

	addUser(user: User) {
		let headers = new Headers({'Content-Type': 'application/json'});
		let options = new RequestOptions({headers: headers});
		let body = JSON.stringify(user);

		let url = '/api/users/insert';
		return this.http.post(url, body, options).map(response => response.json());
	}
}
