import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from 'app/home/home.component';
import { UsersComponent } from 'app/users/users.component';

// @formatter:off
const appRoutes: Routes = [
	{path: '', component: HomeComponent},
	{path: 'users', component: UsersComponent},
];

@NgModule({
	imports: [
		RouterModule.forRoot(appRoutes, {useHash: true})
	],
	exports: [
		RouterModule
	]
})

export class AppRoutesModule {}
