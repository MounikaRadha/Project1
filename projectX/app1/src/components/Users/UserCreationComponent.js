import { useForm } from "react-hook-form";
import UserService from "./UserService";
import '../../styles/Common.css'

const UserCreationComponent = () => {
  const sendUserCreationRequest = UserService.useCreateUser();
  const {
    handleSubmit,
    formState: { errors },
    register,
    reset,
  } = useForm();

  const onSubmit = async (data) => {
    //will handle the form take data and call creation rquest
    const res = await sendUserCreationRequest(data);
  };

  return (
    <div className="creation-container">
      <h2>Create user</h2>
      <form onSubmit={handleSubmit(onSubmit)} className="creation-form">
        <label>username:</label>
        <input type="text" name="userName" {...register("username")}  className="input-field"/>
       <label> password:</label>
        <input type="text" name="password" {...register("password")}  className="input-field"/>
        <button  type="submit" className="create-btn">register user</button>
      
        <button  type="submit" className="reset-btn" onClick={() => reset()}>Reset</button>
      </form>
    </div>
  );
};
export default UserCreationComponent;
