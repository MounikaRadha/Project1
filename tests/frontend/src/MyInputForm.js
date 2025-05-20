import { useState } from "react";
import axios from "axios";
const MyInputForm = () => {
  const [businessType, setBusinessType] = useState("");
  const [targetAudience, setTargetAudience] = useState("");
  const [keySellingPoints, setKeySellingPoints] = useState("");

  const sendTobackend = async (data) => {
    try {
      const response = await axios.post("http://localhost:8080/home/saveData", data);
      console.log("Response from backend:", response.data);
    } catch (error) {
      console.error("Error sending data to backend:", error);
    }
  }
  const handleSubmit = (event) => {
    event.preventDefault();
    // Use current state values (since inputs are controlled)
    console.log("businessType:", businessType);
    console.log("targetAudience:", targetAudience);
    console.log("keySellingPoints:", keySellingPoints);
    sendTobackend({
      businessType,
      targetAudience,
      keySellingPoints,
    });
  };

  return (
    <div>
      <h1>Hello World!</h1>
      <form onSubmit={handleSubmit}>
        businessType:{" "}
        <input
          name="businessType"
          type="text"
          placeholder="Enter your businessType"
          value={businessType}
          onChange={(e) => setBusinessType(e.target.value)}
        />
        <br />
        targetAudience:{" "}
        <input
          name="targetAudience"
          type="text"
          placeholder="Enter your targetAudience"
          value={targetAudience}
          onChange={(e) => setTargetAudience(e.target.value)}
        />
        <br />
        keySellingPoints{" "}
        <input
          name="keySellingPoints"
          type="text"
          placeholder="Enter your keySellingPoints"
          value={keySellingPoints}
          onChange={(e) => setKeySellingPoints(e.target.value)}
        />
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default MyInputForm;
