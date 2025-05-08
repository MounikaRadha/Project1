import { useState } from "react";
import requests from "../api/requests";
import URL_CONSTANTS from "../constants/URL_CONSTANTS";

export default function MyPhone() {
  const [phoneNumber, setPhoneNumber] = useState("");

  const handleChange = (e) => {
    setPhoneNumber(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("phone: " + phoneNumber);
    requests.get(URL_CONSTANTS.ADD_PHONE_NUMBER_ENDPOINT, phoneNumber);
  };

  return (
    <div className="min-h-screen flex items-center justify-center">
      <form
        onSubmit={handleSubmit}
        className=" p-8 rounded-2xl  w-full max-w-md space-y-6 border"
      >
        <h2 className="text-2xl font-bold text-center">
          Enter Your Phone Number
        </h2>

        <div className="space-y-14">
          <label htmlFor="phoneNumber" className="block">
            Phone Number:
          </label>
          <input
            type="text"
            name="phoneNumber"
            id="phoneNumber"
            placeholder="Please enter phone number"
            onChange={handleChange}
            className="w-full px-4 py-2 rounded-lg text-black focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>

        <button
          type="submit"
          className="w-full px-4 py-2 rounded-lg font-semibold"
        >
          Submit
        </button>
      </form>
    </div>
  );
}
