import axios from "axios";
import URL_Constants from "../constants/Url_Constants";
const get = async(url) => {
  try {
    const headers = {
        "Content-Type": "application/json"
      };
    const final_url = URL_Constants.BACKEND_URL + url;
    console.log("final_url is " + final_url);
    const res = await axios.get(final_url,{headers});
    console.log("res is " + res + " for " + final_url);
    return res;
  } catch (e) {
    console.log("err happpened " + e);
  }
};
const ApiService = { get };
export default ApiService;
