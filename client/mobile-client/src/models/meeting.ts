import {ParticipationRating} from "./participation-rating";

export class Meeting {

  id: number;
  teamsInvolved: number[];
  participationRatings: ParticipationRating[];
  description: string;

  constructor() {
  }

}
