import { Component } from '@angular/core';

@Component({
	// selector: '[app-servers]' by attribute
	// selector: '.app-servers', by class
	selector: 'app-servers',
	templateUrl: './servers.component.html',
	styleUrls: ['./servers.component.scss']
})
export class ServersComponent {
	showServerBox: boolean = true;
	addServerTrue: boolean = true;

	serverName: string = 'Server Name';

	constructor() {

	}

	onServerCreate() {
		this.addServerTrue = true;
		this.showServerBox = false;
	}

	addServer() {
		this.addServerTrue = false;
		this.showServerBox = true;
		this.serverName = 'Server Name';
	}
}
