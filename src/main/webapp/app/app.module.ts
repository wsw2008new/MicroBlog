import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2Webstorage } from 'ng2-webstorage';
import { MicroblogAccountModule } from './account/account.module';
import { MicroblogAdminModule } from './admin/admin.module';
import { PaginationConfig } from './blocks/config/uib-pagination.config';

import { customHttpProvider } from './blocks/interceptor/http.provider';
import { MicroblogEntityModule } from './entities/entity.module';
import { MicroblogHomeModule } from './home/home.module';
import { ActiveMenuDirective, ErrorComponent, FooterComponent, JhiMainComponent, LayoutRoutingModule, NavbarComponent, PageRibbonComponent, ProfileService } from './layouts';

import { MicroblogSharedModule, UserRouteAccessService } from './shared';
import './vendor.ts';

// jhipster-needle-angular-add-module-import JHipster will add new module here

@NgModule({
    imports: [
        BrowserModule,
        LayoutRoutingModule,
        Ng2Webstorage.forRoot({prefix: 'jhi', separator: '-'}),
        MicroblogSharedModule,
        MicroblogHomeModule,
        MicroblogAdminModule,
        MicroblogAccountModule,
        MicroblogEntityModule
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective,
        FooterComponent
    ],
    providers: [
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [JhiMainComponent]
})
export class MicroblogAppModule {
}
