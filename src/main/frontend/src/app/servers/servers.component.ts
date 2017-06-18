import { Component, OnInit } from '@angular/core';
import { Server } from 'app/servers/servers.model';

@Component({
	selector: 'app-servers',
	templateUrl: './servers.component.html',
	styleUrls: ['./servers.component.scss']
})

export class ServersComponent implements OnInit {
	servers: Server[] = [];
	serverModel: Server;

	ngOnInit() {
		this.servers = [
			this.serverModel = new Server(1, 'server1', 'offline'),
			this.serverModel = new Server(2, 'server2', 'online')
		];
	}

	addServer(server: Server) {
		this.servers.push(server)
	}
}
