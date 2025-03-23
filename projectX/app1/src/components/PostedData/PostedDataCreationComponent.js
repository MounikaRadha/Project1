import { useForm } from "react-hook-form";
import PostedDataService from "./PostedDataService";
import '../../styles/Common.css'

const PostedDataCreationComponent = () => {
  const sendPostedDataCreationRequest = PostedDataService.useCreatePostedData();
  const {
    handleSubmit,
    formState: { errors },
    register,
    reset,
  } = useForm();

  const onSubmit = (data) => {
    sendPostedDataCreationRequest(data);
  };

  return (
    <div className="creation-container">
       <h2>Create Post Data</h2>
      <form onSubmit={handleSubmit(onSubmit)} className="creation-form">
        <label>endpoint:</label>
        <input type="text" name="endpoint" {...register("endpoint")} className="input-field"  />
        
       <label> postData:</label>
        <input type="text" name="postData" {...register("postData")} className="input-field"  />
 
       <label> tags:</label>
        <input type="text" name="tags" {...register("tags")} className="input-field" />
  
        <button type="submit" className="create-btn">ceation post data</button>
        <button type="button" className="reset-btn" onClick={() => reset()}>Reset</button>
    
      </form>
    
    </div>
  );
};

export default PostedDataCreationComponent;
