## aws
## cidr
- https://aws.amazon.com/what-is/cidr/
- x.x.x.x/16 tells first 16 bits for network and remaiing 32-16 are for host identification
## vpc route tables subnets
- https://docs.aws.amazon.com/vpc/latest/userguide/subnet-route-tables.html
- a vpc(just a network) will be having subnets
- we create vpc ,we attach subnets to vpc
- each vpc has a default created main route table
- each subnet need to have a separate route table
- main route table will handle requests which are not included in all subnets route tables
- public subnet which has access to internet https://docs.aws.amazon.com/vpc/latest/userguide/configure-subnets.html 
- public subnet: The subnet has a direct route to an internet gateway.
- we can enable internet access for a VPC using an internet gateway
- In order to make subnet public, add a route to your subnet’s route table that directs internet-bound traffic to the internet gateway.
## security groups
- https://docs.aws.amazon.com/vpc/latest/userguide/vpc-security-groups.html
- security groups can be attached to any resouce
- these act like firewall
- we write inbound and outboud rules such as allow ssh ,disallow smtp
## ecs
- https://docs.aws.amazon.com/AmazonECS/latest/developerguide/clusters.html
- An Amazon ECS cluster is a logical grouping of tasks or services
- we create clusters to separate your resources.
- Clusters are AWS Region specific.
- Clusters can be in any of the following states(active(The cluster is ready to accept tasks and, if applicable, you can register container instances with the cluster.), PROVISIONING,)
- in cluster we can see services,tasks,infra,scheduled tasks
,we can filter services by launch type(ec2,fargate)
## ecs task definitions
- https://docs.aws.amazon.com/AmazonECS/latest/developerguide/task_definitions.html
- A task definition is a blueprint for your application
- A task is the instantiation of a task definition within a cluster