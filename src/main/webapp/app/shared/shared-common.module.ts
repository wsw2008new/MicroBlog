import { NgModule } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { FindLanguageFromKeyPipe, JhiAlertComponent, JhiAlertErrorComponent, JhiLanguageHelper, MicroblogSharedLibsModule } from './';

@NgModule({
	imports: [
		MicroblogSharedLibsModule
	],
	declarations: [
		FindLanguageFromKeyPipe,
		JhiAlertComponent,
		JhiAlertErrorComponent
	],
	providers: [
		JhiLanguageHelper,
		Title
	],
	exports: [
		MicroblogSharedLibsModule,
		FindLanguageFromKeyPipe,
		JhiAlertComponent,
		JhiAlertErrorComponent
	]
})
export class MicroblogSharedCommonModule {
}
