import AppConstants from "../constants/AppConstants";
const setUserIdInLocalStorage = (userId) => {
  localStorage.setItem(AppConstants.USER_ID_KEY, userId);
};
const getUserIdFromLocalStorage = () => {
  return localStorage.getItem(AppConstants.USER_ID_KEY);
};

const includeUserIdInRequest = (data) => {
  data["userId"] = getUserIdFromLocalStorage();
  return data;
};
const UserIdManagementUtil = {
  setUserIdInLocalStorage,
  getUserIdFromLocalStorage,
  includeUserIdInRequest,
};
export default UserIdManagementUtil;
