import UsersListViewComponent from "./UsersListViewComponent";
import UserService from "./UserService";
import UserCreationComponent from "./UserCreationComponent";
import "../../styles/Common.css";

const UsersComponent = () => {
  const userData = UserService.useFindAllUsers();

  return (
    <div className="my-container">
      <div className="creation-section">
        <UserCreationComponent />
      </div>
      <div className="list-section">
        <UsersListViewComponent usersList={userData} />
      </div>
    </div>
  );
};

export default UsersComponent;
