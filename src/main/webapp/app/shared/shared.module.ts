import { DatePipe } from '@angular/common';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';

import { AccountService, AuthServerProvider, CSRFService, HasAnyAuthorityDirective, JhiLoginModalComponent, LoginModalService, LoginService, MicroblogSharedCommonModule, MicroblogSharedLibsModule, Principal, StateStorageService, UserService } from './';

@NgModule({
	imports: [
		MicroblogSharedLibsModule,
		MicroblogSharedCommonModule
	],
	declarations: [
		JhiLoginModalComponent,
		HasAnyAuthorityDirective
	],
	providers: [
		LoginService,
		LoginModalService,
		AccountService,
		StateStorageService,
		Principal,
		CSRFService,
		AuthServerProvider,
		UserService,
		DatePipe
	],
	entryComponents: [JhiLoginModalComponent],
	exports: [
		MicroblogSharedCommonModule,
		JhiLoginModalComponent,
		HasAnyAuthorityDirective,
		DatePipe
	],
	schemas: [CUSTOM_ELEMENTS_SCHEMA]

})
export class MicroblogSharedModule {
}
