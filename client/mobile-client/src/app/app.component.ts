import { Component, ViewChild } from '@angular/core';
import { Platform, Nav, Config } from 'ionic-angular';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { MainMenuPage } from '../pages/main-menu/main-menu';
import { TeamsListPage } from '../pages/teams-list/teams-list';

import { Settings } from '../providers/settings';

import { TranslateService } from '@ngx-translate/core'



@Component({
  templateUrl: 'app.component.html'
})
export class MyApp {
  private appLoaded = false;
  private rootPage = TeamsListPage; //TODO

  @ViewChild(Nav) nav: Nav;

  pages: any[] = [
    //TODO: pages here like below
    //{ title: 'Tutorial', component: TutorialPage },
  ]

  constructor(private translate: TranslateService,
              private platform: Platform,
              private settings: Settings,
              private config: Config,
              private statusBar: StatusBar,
              private splashScreen: SplashScreen) {

    this.initTranslate();
    this.splashScreen.show();

    platform.ready().then(() => {
      statusBar.styleDefault();
    }).then(
      () => {
        this.appLoaded = true;
      }
    )
  }

  initTranslate() {
    // Set the default language for translation strings, and the current language.
    this.translate.setDefaultLang('en');

    if (this.translate.getBrowserLang() !== undefined) {
      this.translate.use(this.translate.getBrowserLang());
    } else {
      this.translate.use('en'); // Set your language here
    }

    this.translate.get(['BACK_BUTTON_TEXT']).subscribe(values => {
      this.config.set('ios', 'backButtonText', values.BACK_BUTTON_TEXT);
    });
  }

  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
    this.nav.setRoot(page.component);
  }
}
