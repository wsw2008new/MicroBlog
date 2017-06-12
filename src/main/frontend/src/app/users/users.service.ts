import {Http, Response} from "@angular/http";
import "rxjs/Rx";
import {User} from "./users.model";
import {EventEmitter, Injectable} from "@angular/core";

@Injectable()
export class UserService {

  onUserAdded = new EventEmitter<User>();

  constructor(private http: Http) {}

  getUsers(){
    return this.http.get('/api/users/all')
      .map(
        (response: Response) => {
          return response.json();
        }
      );
  }
}
