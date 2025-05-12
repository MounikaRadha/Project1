## news 
## tech 
- frontend: react,tailwind css
- backend : spring boot(java)
- database: mysql
- aws     :ecs,tasks,route53,hosted zone,load balancer,target group,security groups,internet gateway,vpc,subnet
- razor pay integraion
## description
- a user gives their email
- pays one rupee via upi(phone pay),cards etc
- user will get eenadu news paper top 10 news headlines daily
## how it works
- a amazon event bridge will trigger a lambda function daily
- the lambda function(python) will hit a controller in backend
- the controller scrapes that days news paper of eenadu
- shares it via email to the subscribed users
- when user adds email,they will be asked to pay a rupee
- once payment finishes ,user will be added to subscribers list