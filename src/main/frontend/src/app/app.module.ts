import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpModule } from "@angular/http";
import { FormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import { UsersComponent } from "./users/users.component";
import { UserService } from "./users/users.service";
import { ServerComponent } from "./servers/server/server.component";
import { ServersComponent } from "./servers/servers.component";
import { AlertsComponent } from './alerts/alerts.component';
import { WarningAlertComponent } from "./alerts/warning-alert/warning-alert.component";
import { SuccessAlertComponent } from "./alerts/success-alert/success-alert.component";

@NgModule({
	declarations: [
		AppComponent,
		UsersComponent,
		ServerComponent,
		ServersComponent,
		AlertsComponent,
		WarningAlertComponent,
		SuccessAlertComponent
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
