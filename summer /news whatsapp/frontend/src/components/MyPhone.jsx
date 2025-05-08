import { useState } from "react"
export default function MyPhone(){
const [phoneNumber, setPhoneNumber] = useState("")
const handleChange = (e) => {
    setPhoneNumber(e.target.value)
}
const handleSubmit = (e) => {
    e.preventDefault()
    console.log("pone"+phoneNumber)
    // Add your submit logic here
}       
    return(
        <div>
            <form onSubmit={handleSubmit}>
            from my phone
           phone: <input type="text" name="phoneNumber" placeholder="please enter phone number" onChange={handleChange}/>
           <button type="submit"  >Submit</button>
           </form>
        </div>
    )
}