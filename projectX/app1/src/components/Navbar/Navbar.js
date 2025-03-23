import URL_Constants from "../../constants/Url_Constants";

const Navbar=()=>{
    return(
        <>
       <a href={URL_Constants.BASE_NAME+URL_Constants.USERS_PATH}> users </a>
        <a href={URL_Constants.BASE_NAME+URL_Constants.END_POINTS_PATH}>endpoint </a>
        <a href={URL_Constants.BASE_NAME+URL_Constants.POSTED_DATA_PATH}>postedData</a>
        <a href={URL_Constants.BASE_NAME+"/counter"}> counter</a>
        <a href={URL_Constants.BASE_NAME}>home</a>
        </>
    )
}
export default Navbar;