import AppConstants from "../constants/AppConstants";

const setUserIdInLocalStorage = (userId) => {
  localStorage.setItem(AppConstants.USER_ID_KEY, userId);
};
const getUserIdFromLocalStorage = () => {
  return localStorage.getItem(AppConstants.USER_ID_KEY);
};
const UserIdManagementUtil = {
  setUserIdInLocalStorage,
  getUserIdFromLocalStorage,
};
export default UserIdManagementUtil;
