import URL_CONSTANTS from "../constants/URL_CONSTANTS";
import axios from "axios";
const get = async ( endpoint,emailAddress ) => {
  const myUrl= URL_CONSTANTS.BACKEND_URL + endpoint;
 const res= await axios.get(myUrl,{params:{emailAddress:emailAddress}});
  return res.data;
};

const requests = {get};
export default requests;
