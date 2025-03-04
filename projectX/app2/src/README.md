## new tech
flyway
custom annotations
custom exceptions
specifications
pagination
jwt authorization
password hashing
spring filters
base entities
global exception handler
java reflection
user context
factory design principle
mappers
## descripiton
- once user post request comes,we save the hash of salted password
- when user want to login they can give jwt token,or userId,password
- once per request filter will validate user if these details are present
- once user is validated, users details will be saved in UserContext(in thread local)
- user can create a endpoint and user will be the owner of it
- any one can post data to these endpoints
- custom exceptions are used to throw errs
- pagination technique is used for all get requests
- for some database queries custom specifications were made like get users by name
- when user wants to do any authorized tasks like delete,create validation is being done
- custom annotations are used for validation purpose
- for db modals as id is common in all db modals ,a base entity is used
- for handling of exceptions global exception handler was put in place to have more customization
- mappers are used for common conversions like entities to dtos
- other small concepts:reflection,factory design principle
- migrations to run automatically on post construct via flyway
