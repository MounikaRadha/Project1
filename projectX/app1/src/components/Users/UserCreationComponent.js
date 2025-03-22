import { useForm } from "react-hook-form";
import UserService from "./UserService";
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
   const res= await sendUserCreationRequest(data);
  };


  return (
    <>
      <p>user creation component</p>
      <form onSubmit={handleSubmit(onSubmit)}>
        username:
        <input type="text" name="userName" {...register("username")} />
        <br />
        password:{" "}
        <input type="text" name="password" {...register("password")} />
        <br />
        <button>register user</button>
        <br />
        <button onClick={() => reset()}>reset</button>
      </form>
    </>
  );
};
export default UserCreationComponent;
