import UsersListViewComponent from "./UsersListViewComponent";
import UserService from "./UserService";
import UserCreationComponent from "./UserCreationComponent";

const UsersComponent = () => {
  const userData = UserService.useFindAllUsers();

  return (
    <>
      <h1>Users Page</h1>
      <UsersListViewComponent usersList={userData} />
      <UserCreationComponent />
    </>
  );
};

export default UsersComponent;
