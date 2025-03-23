import { useEffect, useState } from "react";
import ApiService from "../../api/ApiService";
import URL_Constants from "../../constants/Url_Constants";

const useFindAllUsers = () => {
  //when userFindAllUsers hook is called useEffect runs and users will be fetched and data will returned
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

const useCreateUser = () => {
  //it will return a function
  // username, passowrd as object will be given as data
  //will make post request and response will be returnend
  const sendUserCreationRequest = async (data) => {
    const res = await ApiService.post(URL_Constants.USERS, data);
    if (res?.status === 200) {
      window.alert(getSuccessMessage(res));
    } else {
      window.alert(res?.message || "invaid creds provided");
    }
    return res;
  };
  return sendUserCreationRequest;
};

const getSuccessMessage=(res)=>{
  if(res?.data?.username?.includes("token")){
    return "user logged in successfully"
  }
  else{
    return "user created successfully"
  }
}

const UserService = { useFindAllUsers, useCreateUser };
export default UserService;
