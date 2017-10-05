import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TeamsListPage } from './teams-list';

@NgModule({
  declarations: [
    TeamsListPage,
  ],
  imports: [
    IonicPageModule.forChild(TeamsListPage),
  ],
})
export class TeamsListPageModule {}
