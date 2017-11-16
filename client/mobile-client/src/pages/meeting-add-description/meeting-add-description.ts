import { Component } from '@angular/core';
import {App, NavController, NavParams} from 'ionic-angular';
import {Meeting} from "../../models/meeting";
import {MeetingService} from "../../providers/meeting-service";
import {MeetingManagementPage} from "../meeting-management/meeting-management";

/**
 * Generated class for the MeetingAddDescriptionPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-meeting-add-description',
  templateUrl: 'meeting-add-description.html',
})
export class MeetingAddDescriptionPage {

  description: string;
  saveMeetingInvoked: boolean = false;
  participantsWithRatings: any[] = [];
  chosenTeams: number[];

  constructor(public navCtrl: NavController, public navParams: NavParams, private appCtrl: App, private meetingService: MeetingService) {
    this.participantsWithRatings = navParams.get("participantsWithRatings");
    this.chosenTeams = navParams.get("chosenTeams");
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad MeetingAddDescriptionPage');
  }

  send(event) {
    this.meetingService.addMeeting(this.prepareMeeting());
    this.saveMeetingInvoked = true;
  }

  returnToMenu(event) {
    this.appCtrl.getRootNav().popToRoot();
  }

  private prepareMeeting(): Meeting {
    let meeting: Meeting = new Meeting();
    this.chosenTeams.forEach(chosenTeam => {
      meeting.teamsInvolved.push(chosenTeam);
    });

    this.participantsWithRatings.forEach(participantWithRating => {
      participantWithRating.rating.teamMemberId = participantWithRating.member.memberId;
    });

    this.participantsWithRatings.forEach(participantWithRating => {
      meeting.participationRatings.push(participantWithRating.rating);
    });
    meeting.description = this.description;
    return meeting;
  }

}
