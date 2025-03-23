import AppConstants from "../constants/AppConstants";

const setJwtToken=(token)=>{
localStorage.setItem(AppConstants.JWT_TOKEN_KEY,token)
}
const getJwtToken=()=>{
    localStorage.getItem(AppConstants.JWT_TOKEN_KEY)
}
const JwtTokenManagementUtil={setJwtToken,getJwtToken}
export default JwtTokenManagementUtil;