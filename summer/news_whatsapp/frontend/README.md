## working process of front end
- the main functionlity will be in my email component
- when user adds mail we send requst to backend 
- backend will return a order id(razor pay orders api)
- with the data returned from backend we proceed to payment
- once payment finishes we send the details to backend
- in backend verification of payment signature wil be done 
- if correct payment is done, user email added to subscribers list
- user will get email immediatly
## deployment
- use env variables ,use vercel