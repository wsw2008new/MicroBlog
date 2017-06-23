import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from 'app/header/header.component';
import { HomeComponent } from 'app/home/home.component';
import { UsersAddComponent } from 'app/users/users-add/users-add.component';

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { UserService } from './users/users.service';

const appRoutes: Routes = [
	{path: '', component: HomeComponent},
	{path: 'users', component: UsersComponent},
	{path: 'users/add', component: UsersAddComponent}
];

@NgModule({
	declarations: [
		AppComponent,
		UsersComponent,
		UsersAddComponent,
		HeaderComponent,
		HomeComponent
	],
	imports: [
		BrowserModule,
		HttpModule,
		FormsModule,
		RouterModule.forRoot(appRoutes)
	],
	providers: [UserService],
	bootstrap: [AppComponent]
})

export class AppModule {
}
