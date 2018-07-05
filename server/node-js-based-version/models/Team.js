'use strict';

module.exports = class Team {
  constructor(id, name, members) {
    this.id = id;
    this.name = name;
    this.members = members;
  }

  get JSON() {
    return JSON.stringify({
      id: this.id, 
      name: this.name,
      members: this.members
    });
  }

  static fromJSON(json) {
    var data = JSON.parse(json);
    var team = new Team(data.id, dataame, data.members);
    return team;
  }
};