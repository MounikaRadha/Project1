import { useState } from "react";
import ApiService from "../api/ApiService";
import URL_Constants from "../constants/Url_Constants";

const UsersData = ({ availableUsers }) => {
  return availableUsers?.content?.map((x) => <p>{x["username"]}</p>);
};
const Counter = () => {
  const [availaleUsers, setAvailableUsers] = useState();
  const [count, setCount] = useState(0);
  const incrementCount = async () => {
    const res = await ApiService.get(URL_Constants.USERS);
    setAvailableUsers(res);
    setCount((count) => count + 1);
  };
  return (
    <div>
      <UsersData availableUsers={availaleUsers} />
      The count is {count}
      <button onClick={incrementCount}>increase count</button>
    </div>
  );
};
export default Counter;
