import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutesModule } from 'app/app-routes.module';
import { HeaderComponent } from 'app/header/header.component';
import { HomeComponent } from 'app/home/home.component';

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { UserService } from './users/users.service';

@NgModule({
	declarations: [
		AppComponent,
		UsersComponent,
		HeaderComponent,
		HomeComponent
	],
	imports: [
		BrowserModule,
		HttpModule,
		ReactiveFormsModule,
		AppRoutesModule
	],
	providers: [UserService],
	bootstrap: [AppComponent]
})

export class AppModule {
}
