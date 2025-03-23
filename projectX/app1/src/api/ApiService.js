import JwtTokenManagementUtil from '../utils/JwtTokenManagementUtil'
import axios from "axios";
const get = async (url) => {
  const config={headers:{"Authorization":JwtTokenManagementUtil.getJwtToken()}}
  try {
    const res = await axios.get(url,config);
    return res;
  } catch (e) {
    console.log("error while making get request for url " + url + e);
  }
};
const post = async (url, payload) => {
  const config={headers:{"Authorization":JwtTokenManagementUtil.getJwtToken()}}
  try {
    const res = await axios.post(url, payload,config);
    return res;
  } catch (e) {
    console.log("error while making post request for url " + url + e);
  }
};
const ApiService = { get, post };
export default ApiService;
