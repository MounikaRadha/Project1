import { useEffect, useState } from "react";
import ApiService from "../../api/ApiService";
import URL_Constants from "../../constants/Url_Constants";

const useFindAllEndPoints = async () => {

  const [endPointsData, setEndPointsData] = useState();

  const fetchAllEndPoints = async () => {
    const res = await ApiService.get(URL_Constants.END_POINTS);
    setEndPointsData(res?.data?.content);
    return endPointsData;
  };

  useEffect(() => {
    fetchAllEndPoints();
  },[]);
  return endPointsData;
  
};

const useCreateEndPoint = () => {};
const EndPointService = { useFindAllEndPoints, useCreateEndPoint };
export default EndPointService;
