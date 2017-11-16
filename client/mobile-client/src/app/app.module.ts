import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule, Http } from '@angular/http';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { Storage, IonicStorageModule } from '@ionic/storage';

import { MyApp } from './app.component';
import { MainMenuPage } from '../pages/main-menu/main-menu';
import { MemberPage } from '../pages/member/member';
import { MemberListPage } from '../pages/member-list/member-list';
import { TeamPage } from '../pages/team/team';
import { TeamsListPage } from '../pages/teams-list/teams-list';

import { Api } from '../providers/api';
import { Items } from '../mocks/providers/items';
import { Settings } from '../providers/settings';

import { Camera } from '@ionic-native/camera';
import { GoogleMaps } from '@ionic-native/google-maps';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';

import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { TeamService } from '../providers/team-service';
import { TeamRestService } from '../providers/team-rest-service';
import { MemberRestService } from '../providers/member-rest-service';
import { MemberService } from '../providers/member-service';
import {MemberDetailsPage} from "../pages/member-details/member-details";
import {ModifyMemberDetailsPage} from "../pages/modify-member-details/modify-member-details";
import {TeamManagementPage} from "../pages/team-management/team-management";
import {PersonService } from '../providers/person-service';
import {PersonPage} from "../pages/person/person";
import {PersonListPage} from "../pages/person-list/person-list";
import {PersonDetailsPage} from "../pages/person-details/person-details";
import {PersonManagementPage} from "../pages/person-management/person-management";
import {PersonRestService } from '../providers/person-rest-service';
import {PersonAddPage} from "../pages/person-add/person-add";
import {TeamAddPage} from "../pages/team-add/team-add";
import {TeamMemberAddPage} from "../pages/team-member-add/team-member-add";
import { MeetingService } from '../providers/meeting-service';
import { MeetingRestService } from '../providers/meeting-rest-service';
import {MeetingManagementPage} from "../pages/meeting-management/meeting-management";
import {MeetingsListPage} from "../pages/meetings-list/meetings-list";
import {MeetingPage} from "../pages/meeting/meeting";
import {MeetingAddTeamsPage} from "../pages/meeting-add-teams/meeting-add-teams";
import {MeetingAddParticipantsPage} from "../pages/meeting-add-participants/meeting-add-participants";
import {MeetingRateActivityPage} from "../pages/meeting-rate-activity/meeting-rate-activity";
import {MeetingRateBehaviorPage} from "../pages/meeting-rate-behavior/meeting-rate-behavior";
import {MeetingRatePresencePage} from "../pages/meeting-rate-presence/meeting-rate-presence";
import {MeetingRatePunctualityPage} from "../pages/meeting-rate-punctuality/meeting-rate-punctuality";
import {MeetingRateUniformPage} from "../pages/meeting-rate-uniform/meeting-rate-uniform";
import {MeetingDetailsPage} from "../pages/meeting-details/meeting-details";
import {MeetingAddDescriptionPage} from "../pages/meeting-add-description/meeting-add-description";

// The translate loader needs to know where to load i18n files
// in Ionic's static asset pipeline.
export function HttpLoaderFactory(http: Http) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

export function provideSettings(storage: Storage) {
  /**
   * The Settings provider takes a set of default settings for your app.
   *
   * You can add new settings options at any time. Once the settings are saved,
   * these values will not overwrite the saved values (this can be done manually if desired).
   */
  return new Settings(storage, {
    option1: true,
    option2: 'Ionitron J. Framework',
    option3: '3',
    option4: 'Hello'
  });
}

@NgModule({
  declarations: [
    MyApp,
    MainMenuPage,
    MemberPage,
    MemberDetailsPage,
    MemberListPage,
    MeetingAddDescriptionPage,
    MeetingAddTeamsPage,
    MeetingAddParticipantsPage,
    MeetingDetailsPage,
    MeetingRateActivityPage,
    MeetingRateBehaviorPage,
    MeetingRatePresencePage,
    MeetingRatePunctualityPage,
    MeetingRateUniformPage,
    MeetingPage,
    MeetingManagementPage,
    MeetingsListPage,
    ModifyMemberDetailsPage,
    TeamAddPage,
    TeamMemberAddPage,
    TeamPage,
    TeamsListPage,
    TeamManagementPage,
    PersonAddPage,
    PersonPage,
    PersonListPage,
    PersonDetailsPage,
    PersonManagementPage
    //TODO: pages here
  ],
  imports: [
    BrowserModule,
    HttpModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [Http]
      }
    }),
    IonicModule.forRoot(MyApp),
    IonicStorageModule.forRoot()
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    MainMenuPage,
    MemberPage,
    MemberDetailsPage,
    MemberListPage,
    MeetingAddDescriptionPage,
    MeetingAddTeamsPage,
    MeetingAddParticipantsPage,
    MeetingDetailsPage,
    MeetingRateActivityPage,
    MeetingRateBehaviorPage,
    MeetingRatePresencePage,
    MeetingRatePunctualityPage,
    MeetingRateUniformPage,
    MeetingPage,
    MeetingManagementPage,
    MeetingsListPage,
    ModifyMemberDetailsPage,
    TeamAddPage,
    TeamMemberAddPage,
    TeamPage,
    TeamsListPage,
    TeamManagementPage,
    PersonAddPage,
    PersonPage,
    PersonListPage,
    PersonDetailsPage,
    PersonManagementPage
    //TODO: pages here
  ],
  providers: [
    Api,
    Items,
    Camera,
    GoogleMaps,
    SplashScreen,
    StatusBar,
    { provide: Settings, useFactory: provideSettings, deps: [Storage] },
    // Keep this to enable Ionic's runtime error handling during development
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    TeamService,
    TeamRestService,
    MemberService,
    MemberRestService,
    PersonService,
    PersonRestService,
    MeetingService,
    MeetingRestService
  ]
})
export class AppModule { }
