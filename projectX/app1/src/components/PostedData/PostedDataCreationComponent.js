import { useForm } from "react-hook-form";
import PostedDataService from "./PostedDataService";
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
    console.log("post data creation on submit called");
  };
  return (
    <>
      <p>posted Data creation component</p>
      <form onSubmit={handleSubmit(onSubmit)}>
        endpoint:
        <input type="text" name="endpoint" {...register("endpoint")} />
        <br />
        userId:
        <input type="text" name="userId" {...register("userId")} />
        <br />
        postData:
        <input type="text" name="postData" {...register("postData")} />
        <br />
        tags:
        <input type="text" name="tags" {...register("tags")} />
        <br />
        <button>ceation post data</button>
      </form>
      <button onClick={() => reset()}>reset</button>
    </>
  );
};

export default PostedDataCreationComponent;
