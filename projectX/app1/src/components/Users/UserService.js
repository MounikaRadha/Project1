import { useEffect, useState } from "react";
import ApiService from "../../api/ApiService";
import URL_Constants from "../../constants/Url_Constants";
const useFindAllUsers = () => {
  const [userData, setUserData] = useState();
  const fetchUsers = async () => {
    const res = await ApiService.get(URL_Constants.USERS);
    setUserData(res?.data?.content);
  };
  useEffect(() => {
    fetchUsers();
  }, []);
  return userData;
};

const UserService = { useFindAllUsers };
export default UserService;
