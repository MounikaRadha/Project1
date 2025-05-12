import URL_CONSTANTS from "../constants/URL_CONSTANTS";
import axios from "axios";
const get = async (endpoint, param) => {
  //to send get request with query param object {email:abc@gmail.com}
  const myUrl = URL_CONSTANTS.BACKEND_URL + endpoint;
  const res = await axios.get(myUrl, {
    params: param,
  });
  return res.data;
};
const post = async (endpoint, body = {}) => {
  const myUrl = URL_CONSTANTS.BACKEND_URL + endpoint;
  const res = await axios.post(myUrl, body);
  return res.data;
};

const requests = { get, post };
export default requests;
