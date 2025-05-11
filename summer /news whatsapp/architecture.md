## ..
- a old python  script which would scrape eenadu newspaper
- a java backend which would call the python file in a service
- this code will be run at schduled times(how to schedule in aws)
- a controller attached to this news calling function(so we can news when we want and not just by scheduler)
## ..
- a frontend in react/next which would have a add phone number interface,so backend will take the number and save in db
- scraped data can be saved in a s3 bucket
- we need to have a backend service which would send the scrapded news to phone numbers
## ..
- integrate payment system ,so users before adding their phone number will need to pay money

- a function to save news``
- we have 2 ways to save news one in db another in s3 bucket
- get news also 2 ways
- send news a separate function 
- we call send news from add email address function and in a cron/scheduler


- a backend controller which would take the payment details from frontend verify the signature and save the user details as completed
- 


- on payment success and after adding email,need to show it in frontend done
- remove unnecessary alerts done 
- code comments done
- refactor done 
- cron job function to go through the db column and call send email function
- code cleanup done 