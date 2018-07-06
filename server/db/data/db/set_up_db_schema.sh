use scout
db.createCollection('meetings')
db.createCollection('members')
db.createCollection('ratings')
db.createCollection('teams')
db.createCollection('persons')
db.createCollection('users')
db.createUser(
  {
    user: "admin",
    pwd: "admin",
    roles: [ { role: "userAdminAnyDatabase", db: "admin" } ]
  }
)
