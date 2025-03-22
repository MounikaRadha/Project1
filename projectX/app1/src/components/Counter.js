import { useState } from "react";
import ApiService from "../api/ApiService";
const Counter=()=>{
const [count,setCount]=useState(0);
const incrementCount=()=>{
    ApiService.get("/")
    setCount((count)=>count+1)
}
return(
    <div>
        The count is {count}
        <button onClick={incrementCount}>increase count</button>
    </div>
)
}
export default Counter;