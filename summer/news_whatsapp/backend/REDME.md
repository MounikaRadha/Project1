## backend
- the home controler has createOrder for cretion of order url,will be hitted when user click the add email and pay button
- handlePayment - this will verify the signature/validity of payment ,will call success payment method
- scrape - will scrape news 
- cronxxx - will be scraping news,go through database of users ,send email to all
- factory desing pattern used to save scrapped news
## deployment 
- use env variable,create docker image,create container with this image in ecs,use this in task,ecs