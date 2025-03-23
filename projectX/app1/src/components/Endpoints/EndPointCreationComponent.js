import { useForm } from "react-hook-form";
import EndPointService from "./EndPointService";
const EndPointCreationComponent=()=>{
    const {handleSubmit,formState:{errors},register,reset}=useForm();
    const sendEndPointCreationRequest=EndPointService.useCreateEndPoint();
    const onSubmit=async(data)=>{
        const res=sendEndPointCreationRequest(data);
    }

return(<>
<p>endpoint creation component</p>
<form onSubmit={handleSubmit(onSubmit)}>
    endpoint:<input type="text" name="endPoint" {...register("endPoint")}/><br/>
    userId:<input type="userId" name="userId" {...register("userId")}/><br/>
    <button>create endpoint</button>
    </form>
    <button onClick={()=>reset()}>reset</button>
    </>)
}
export default EndPointCreationComponent;