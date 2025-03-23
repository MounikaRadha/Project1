import { useEffect, useState } from "react";
import ApiService from "../../api/ApiService";
import URL_Constants from "../../constants/Url_Constants";

const useFindAllEndPoints = () => {
  const [endPointsData, setEndPointsData] = useState();

  const fetchAllEndPoints = async () => {
    const res = await ApiService.get(URL_Constants.END_POINTS);
    setEndPointsData(res?.data?.content);
  };

  useEffect(() => {
    fetchAllEndPoints();
  }, []);
  return endPointsData;
};

const useCreateEndPoint = () => {
  //return a function which takes request data and send post request
  const sendEndPointCreationRequest = async (data) => {
    const res = await ApiService.post(URL_Constants.END_POINTS, data);
    if (res.status == 200) {
      window.alert("endpoint created");
    } else {
      window.alert("endpoint creation failed");
    }
  };
  return sendEndPointCreationRequest;
};
const EndPointService = { useFindAllEndPoints, useCreateEndPoint };
export default EndPointService;
