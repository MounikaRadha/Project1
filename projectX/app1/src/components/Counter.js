import { useState } from "react";
import ApiService from "../api/ApiService";
import URL_Constants from "../constants/Url_Constants";
import UsersListViewComponent from "./Users/UsersListViewComponent";

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
      <UsersListViewComponent usersList={availaleUsers?.data?.content} />
      The count is {count}
      <button onClick={incrementCount}>increase count</button>
    </div>
  );
};
export default Counter;
