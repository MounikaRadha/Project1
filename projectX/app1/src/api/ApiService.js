import axios from "axios";
const get = async (url) => {
  try {
    const headers = {
      "Content-Type": "application/json",
    };
    const res = await axios.get(url, { headers });
    return res;
  } catch (e) {
    console.log("err .. " + e);
  }
};
const ApiService = { get };
export default ApiService;
