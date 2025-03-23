import NoDataInDb from "../NoDataInDb";

import "../../styles/ListViewComponent.css";

const UsersListViewComponent = ({ usersList = [] }) => {
  if (usersList.length > 0)
    return (
      <div className="my-list-container">
        {usersList.map((userItem) => (
          <UserItem key={userItem.id} userItem={userItem} />
        ))}
      </div>
    );
  else return <NoDataInDb modalType={"Users"} />;
};

export default UsersListViewComponent;

export const UserItem = ({ userItem }) => {
  return (
    <div className="my-card">
      {userItem?.id && (
        <p className="my-label">
          <span className="label">User ID:</span> {userItem.id}
        </p>
      )}
      <p className="my-label">
        <span className="label">Username:</span> {userItem.username}
      </p>
    </div>
  );
};
