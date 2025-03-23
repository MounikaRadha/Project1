import AppConstants from "../constants/AppConstants";

const isUserLoggedIn=()=>{
    if(localStorage.getItem(AppConstants.USER_ID_KEY) && localStorage.getItem(AppConstants.JWT_TOKEN_KEY)){
        return true;
    }
    else{
        return false;
    }
}
const logOutUser=()=>{
    localStorage.removeItem(AppConstants.USER_ID_KEY);
    localStorage.removeItem(AppConstants.JWT_TOKEN_KEY)
}

const UserLoginManagementUtil={isUserLoggedIn,logOutUser}
export default UserLoginManagementUtil;