# GraphQL_Demo
Java Springboot application to create GraphQL Api. APi is demo project to create the same api as rickandmorty graphql api.
## Requirements
* java 11<br>
* springboot<br>
* graphql-spqr-spring-boot-starter plugin<br>
* maven
<br>
project has the hardcoded values but also tested with Mongodb.Current version mongodb repositories are excluded and autowire as commented.if project is extended it will be connected with mongodb and uncommented the changes.
<br>With hard code values repository classes are created to reporesent the basic functionlity as curdrepository to find the charachter,locaiton and episode objects.
<br>
Graph SPQR plugin provide the graphql ui which can be used to test the Api functionlity and it is assiessbly with http://localhost:8000/gui.plug is greate in term of code based graphql schema generation.so developer don't need to generrate schema first.plugin automatically generate with api functionlity and code annotations
