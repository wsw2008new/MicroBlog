import { platformBrowser } from '@angular/platform-browser';
import { MicroblogAppModuleNgFactory } from '../../../../target/aot/src/main/webapp/app/app.module.ngfactory';
import { ProdConfig } from './blocks/config/prod.config';

ProdConfig();

platformBrowser().bootstrapModuleFactory(MicroblogAppModuleNgFactory)
.then((success) => console.log(`Application started`))
.catch((err) => console.error(err));
