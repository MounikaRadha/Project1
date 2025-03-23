import { useForm } from "react-hook-form";
import EndPointService from "./EndPointService";
import "../../styles/Common.css";

const EndPointCreationComponent = () => {
  const {
    handleSubmit,
    formState: { errors },
    register,
    reset,
  } = useForm();

  const sendEndPointCreationRequest = EndPointService.useCreateEndPoint();
  const onSubmit = async (data) => {
    sendEndPointCreationRequest(data);
  };

  return (
    <div className="creation-container">
      <h2>Create Endpoint</h2>
      <form onSubmit={handleSubmit(onSubmit)} className="creation-form">
        <label>Endpoint:</label>
        <input type="text" {...register("endPoint")} className="input-field" />
        <button type="submit" className="create-btn">
          Create Endpoint
        </button>
        <button type="button" className="reset-btn" onClick={() => reset()}>
          Reset
        </button>
      </form>
    </div>
  );
};

export default EndPointCreationComponent;
