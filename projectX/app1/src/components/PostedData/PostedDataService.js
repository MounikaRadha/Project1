import { useEffect, useState } from "react";
import ApiService from "../../api/ApiService";
import URL_Constants from "../../constants/Url_Constants";

const useFindAllPostedData = () => {
  const [postedData, setPostedData] = useState();
  const fetchAllPostedData = async () => {
    const res = await ApiService.get(URL_Constants.POSTED_DATA);
    setPostedData(res?.data?.content);
  };
  useEffect(() => {
    fetchAllPostedData();
  }, []);
  return postedData;
};

const useCreatePostedData = () => {
  //return a function which would be making a call to create postedData
  const sendPostedDataCreationRequest = async (data) => {
    const res = await ApiService.post(URL_Constants.POSTED_DATA, data);
    if (res?.status === 200) {
      window.alert("posted data created successfully");
    } else {
      window.alert("posted data creation failed");
    }
    return res;
  };
  return sendPostedDataCreationRequest;
};

const PostedDataService = { useCreatePostedData, useFindAllPostedData };
export default PostedDataService;
