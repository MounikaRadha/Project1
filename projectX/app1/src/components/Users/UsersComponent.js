import UsersListViewComponent from "./UsersListViewComponent";
import UserService from "./UserService";

const UsersComponent = () => {
  const userData = UserService.useFindAllUsers();

  return (
    <>
      <h1>Users Page</h1>

      <UsersListViewComponent usersList={userData} />
    </>
  );
};

export default UsersComponent;
