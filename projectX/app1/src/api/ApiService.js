import axios from "axios";
import URL_Constants from "../constants/Url_Constants";
const get = async(url) => {
  try {
    const headers = {
        "Content-Type": "application/json"
      };
    console.log("url is " + url);
    const res = await axios.get(url,{headers});
    console.log("res is " + res + " for " +url);
    return res?.data;
  } catch (e) {
    console.log("err happpened " + e);
  }
};
const ApiService = { get };
export default ApiService;
