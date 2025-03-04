𝐇𝐢 𝐚𝐥𝐥.....

𝐓𝐞𝐜𝐡 𝐮𝐬𝐞𝐝: 𝐬𝐩𝐫𝐢𝐧𝐠 𝐛𝐨𝐨𝐭

𝐏𝐫𝐨𝐣𝐞𝐜𝐭 𝐨𝐯𝐞𝐫𝐯𝐢𝐞𝐰 𝐚𝐬 𝐞𝐧𝐝 𝐮𝐬𝐞𝐫:

- a website at which we can create account

- login and create our own unique endpoint like hyderabad,iiit, chapathi

- at the created endpoint any other user can post realated information

- restrictions are there so that only owner of endpoint can delete it,and owner of  the post can modify it

𝐏𝐫𝐨𝐣𝐞𝐜𝐭 𝐨𝐯𝐞𝐫𝐯𝐢𝐞𝐰 𝐭𝐞𝐜𝐡𝐧𝐢𝐜𝐚𝐥𝐥𝐲:

- once user post request comes, we save the 𝐡𝐚𝐬𝐡 𝐨𝐟 𝐬𝐚𝐥𝐭𝐞𝐝 𝐩𝐚𝐬𝐬𝐰𝐨𝐫𝐝

- when user want to login they can give 𝐣𝐰𝐭 𝐭𝐨𝐤𝐞𝐧 , or userId, password

- 𝐨𝐧𝐜𝐞 𝐩𝐞𝐫 𝐫𝐞𝐪𝐮𝐞𝐬𝐭 𝐟𝐢𝐥𝐭𝐞𝐫 will validate user if these details are present

- once user is validated, users details will be saved in 𝐔𝐬𝐞𝐫𝐂𝐨𝐧𝐭𝐞𝐱𝐭 (in thread local)

- user can create a endpoint and user will be the owner of it

- any one can post data to these endpoints

- 𝐜𝐮𝐬𝐭𝐨𝐦 𝐞𝐱𝐜𝐞𝐩𝐭𝐢𝐨𝐧s are used to throw errs

- 𝐩𝐚𝐠𝐢𝐧𝐚𝐭𝐢𝐨𝐧 𝐭𝐞𝐜𝐡𝐧𝐢𝐪𝐮𝐞 is used for all get requests

- for some database queries  𝐬𝐩𝐞𝐜𝐢𝐟𝐢𝐜𝐚𝐭𝐢𝐨𝐧𝐬 were made like get users by name

- when user wants to do any authorized tasks like delete,create validation is being done

- 𝐜𝐮𝐬𝐭𝐨𝐦 𝐚𝐧𝐧𝐨𝐭𝐚𝐭𝐢𝐨𝐧𝐬  are used for validation purpose

- for db modals as id is common in all db modals ,a 𝐛𝐚𝐬𝐞 𝐞𝐧𝐭𝐢𝐭𝐲 is used

- for handling of exceptions 𝐠𝐥𝐨𝐛𝐚𝐥 𝐞𝐱𝐜𝐞𝐩𝐭𝐢𝐨𝐧 𝐡𝐚𝐧𝐝𝐥𝐞𝐫 was put in place to have more customization

- 𝐦𝐚𝐩𝐩𝐞𝐫𝐬 are used for common conversions like entities to DTOs

- 𝐦𝐢𝐠𝐫𝐚𝐭𝐢𝐨𝐧𝐬  to run automatically on post construct via 𝐟𝐥𝐲𝐰𝐚𝐲

- other small concepts: reflection,factory design principle

𝐏𝐫𝐨𝐣𝐞𝐜𝐭 𝐬𝐨𝐮𝐫𝐜𝐞 𝐜𝐨𝐝𝐞:-

- https[://]github[.]com/MounikaRadha/Project1/tree/dev/projectX/app2

- https://github.com/MounikaRadha/Project1/tree/dev/projectX/app2



𝔸𝕝𝕝 𝕤𝕦𝕘𝕘𝕖𝕤𝕥𝕚𝕠𝕟𝕤 𝕒𝕣𝕖 𝕨𝕖𝕝𝕔𝕠𝕞𝕖.....:)