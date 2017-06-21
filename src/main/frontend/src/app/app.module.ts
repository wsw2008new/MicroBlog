import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { UserService } from './users/users.service';

@NgModule({
	declarations: [
		AppComponent,
		UsersComponent
	],
	imports: [
		BrowserModule,
		HttpModule,
		FormsModule
	],
	providers: [UserService],
	bootstrap: [AppComponent]
})

export class AppModule {
}
