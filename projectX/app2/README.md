## Hi all.....

### Tech used: Spring Boot

## Project overview as end user:

- A website at which we can create an account.
- Login and create our own unique endpoint like `hyderabad`, `iiit`, `chapathi`.
- At the created endpoint, any other user can post related information.
- Restrictions are there so that only the owner of an endpoint can delete it, and the owner of the post can modify it.

## Project overview technically:

- Once a user post request comes, we save the **hash of salted password**.
- When a user wants to log in, they can give a **JWT token**, or `userId`, `password`.
- **Once per request filter** will validate the user if these details are present.
- Once the user is validated, their details will be saved in **UserContext** (in thread local).
- The user can create an endpoint and will be the owner of it.
- Anyone can post data to these endpoints.
- **Custom exceptions** are used to throw errors.
- **Pagination technique** is used for all `GET` requests.
- For some database queries, **specifications** were made, like getting users by name.
- When a user wants to do any authorized tasks like delete or create, validation is being done.
- **Custom annotations** are used for validation purposes.
- For database models, since `id` is common in all models, a **base entity** is used.
- For handling exceptions, a **global exception handler** was put in place to allow more customization.
- **Mappers** are used for common conversions like entities to DTOs.
- **Migrations** run automatically on post-construct via **Flyway**.
- Other small concepts: **Reflection, Factory Design Principle**.

## Project source code:

- [GitHub Repository](https://github.com/MounikaRadha/Project1/tree/dev/projectX/app2)

_All suggestions are welcome..... :)_
