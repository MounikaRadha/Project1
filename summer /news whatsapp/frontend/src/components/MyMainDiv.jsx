import MyEmail from "./MyEmail";
import MyPayment from "./MyPayment";  

export default function MyMainDiv() {
  return (
    <div  className="h-full w-full  rounded-xl items-center justify-center">
      <MyEmail/>
      {/* <MyPayment/> */}
    </div>
  );
}
