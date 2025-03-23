import NoDataInDb from "../NoDataInDb";

const UsersListViewComponent = ({ usersList = [] }) => {
  if (usersList.length > 0)
    return usersList?.map((userItem) => <UserItem userItem={userItem} />);
  else return <NoDataInDb modalType={"Users"} />;
};
export default UsersListViewComponent;
export const UserItem = ({ userItem }) => {
  return (
    <>
      {userItem?.["id"] && <p>userId:{userItem?.["id"]}</p>}
      <p>user name:{userItem?.["username"]}</p>
    </>
  );
};
