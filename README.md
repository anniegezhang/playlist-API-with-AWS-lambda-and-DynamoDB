# playlist-API-with-AWS-lambda-and-DynamoDB
This REST API is designed to have basic functionality such as create, retrieve, update and delete playlists, 
as well as add songs to them and retrieve their song list. 
CustomerId and playlistId are used to verify customer identity. 
All the playlists are stored in DynamoDB database, as playlistId is the hashkey. 
AWS lambda functions are used to realize the REST API get, post, put and delete methods.


main classes include:
* Activity classes
* DAO classes
* Exception classes
* DynamoDB model classes
