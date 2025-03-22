import axios from "axios";
const get = async (url) => {
  try {
    const res = await axios.get(url);
    return res;
  } catch (e) {
    console.log("error while making get request for url " + url + e);
  }
};
const post = async (url, payload) => {
  try {
    const res = await axios.post(url, payload);
    return res;
  } catch (e) {
    console.log("error while making post request for url " + url + e);
  }
};
const ApiService = { get, post };
export default ApiService;
