import { Http } from "@angular/http";
import { Injectable } from "@angular/core";
import "rxjs/add/operator/map";

@Injectable()
export class UserService {

	private http: Http;

	constructor(http: Http) {
		this.http = http;
	}

	getUsers() {
		return this.http.get('/api/users/all').map(response => response.json());
	}
}
