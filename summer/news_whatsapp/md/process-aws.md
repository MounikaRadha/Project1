## process
- created aws vpc named news-vpc with cidr block 10.0.0.0/24
- created subnet named news-subnet with subnet cidr 10.0.0.0/28 -16 ips with above vpc
- default route table got created with vpc cidr
- we can creaete route table for a vpc
- created internet gateway called news-internet-gateway
- need to go to internet gateway ,attach to vpc
- created ecs cluster called news-cluster with fargate
- for creation of task defintion we need docker urls
- 10.0.0.16/28 one more subnet news-subnet-2
## docker
- docker login
- docker buildx build -t m0wn1ka/news-app-backend .
## ecs
- creted news-task-definition-family task definition family .25 vcpu .5 gb memory aws fargate
- image uri as m0wn1ka/news-app-backend:latest container name as news-backend-container port 8080 added env variables  
## secruity group
- for a vpc with name news-security-group allow all inbound all traffic 0.0.0.0/0 allow all outbound traffic
## target group
- news-target-group with http ipv4  existing vpc
- in register target group setted port as 8080
## load balancer creation
-  news-load-balancer internet facing ipv4 use exising vpc
- A listener is a process that checks for connection requests using the port and protocol you configure. The rules that you define for a listener determine how the load balancer routes requests to its registered targets.
- security group it asked
- it took vpc as wll
- so port 80 `http` above created target group 
- it says the subnet does not have access to internet as it does not have internet gateway https://docs.aws.amazon.com/vpc/latest/userguide/working-with-igw.html
## reoute table
- news-route-table 
- add route with destinattion as 0.0.0.0/0 target as our pre created internet gateway
- go to subnet ,change route table association
## deployment 
### frontend
- deployed in vercel https://project1-iota-flame.vercel.app/
- need to use backend url via env file so localhost:8080 is not hardcoded


## ecs
- go to cluster create service called `news-task-definition-family-service-byrzfmnz`
- environment news cluster
- compute configuration aws fargate(launch type )
- 1 repliaca
- blue green deployment/rolling updaes(give max,min running tasks percentage)
- vpc,subnets,security groups given
- public ip turned on
## create new target group with port 8080
## creat new ecs service 
- as old one we did not use loadbalancing
- use the target group,vpc,subnets,security groups,
- lister at 80 (using existing listner),public ip turn on,launch type fargate
- use the above target group
- change rules in load balancer to use new target group
## 502,503,504,255(immedeiate stop in ecs task) 
- run docker container locally shows db url incorrect
## create database
- rds root:radha
- serverless instance  aurora standard(mysql compatible)
- 0.5 to 1-gb
- public access
- vpc 
- no replica
- initial databasae name news
- Cannot create a publicly accessible DBInstance. The specified VPC does not support DNS resolution, DNS hostnames, or both. Update the VPC and then try again
- https://stackoverflow.com/questions/62875709/the-specified-vpc-does-not-support-dns-resolution-dns-hostnames-or-both-updat
## route 53
- already a domain is registerd and hosted zone is created
- now news.radha-mounika.com ->alias to load balancer in a given region 