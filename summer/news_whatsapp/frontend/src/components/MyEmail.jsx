import { useState } from "react";
import requests from "../api/requests";
import URL_CONSTANTS from "../constants/URL_CONSTANTS";
export default function MyEmail() {
  const [emailAddress, setemailAddress] = useState("");

  const handleChange = (e) => {
    setemailAddress(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    //user entered email address
    //we send the email address to the backend
    //use orders api we generate order
    //with order id we open the razorpay payment gateway
    //after payment we send the payment details to the backend if it is success
    //we send the success message to the frontend(in backend we verify payment signature)
    console.log("email address: " + emailAddress);
    const res = await requests.get(URL_CONSTANTS.CREATE_ORDER_ENDPOINT, {
      emailAddress: emailAddress,
    });
    const options = {
      key: import.meta.env.VITE_RAZOR_KEY_ID,
      amount: "50000000",
      currency: "INR",
      name: "News by Radha",
      description: "Test Transaction",
      image: "https://rguktn.ac.in/assets_new/images/logo.png",
      order_id: res.id,
      handler: async function (response) {
        const res = await requests.post(URL_CONSTANTS.HANDLE_PAYMENT_ENDPOINT, {
          razorpayPaymentId: response.razorpay_payment_id,
          razorpayOrderId: response.razorpay_order_id,
          razorpaySignature: response.razorpay_signature,
          emailAddress: emailAddress,
        });
        alert(res);
      },
      theme: {
        color: "#3399cc",
      },
    };
    const rzp1 = new window.Razorpay(options);
    rzp1.on("payment.failed", function (response) {
      console.log(response.error.code); // The error code as returned by Razorpay
      console.log(response.error.description); // The error description
    });
    rzp1.open();
    e.preventDefault();
  };

  return (
    <div className="min-h-screen flex items-center justify-center">
      <form
        onSubmit={handleSubmit}
        className=" p-8 rounded-2xl  w-full max-w-md space-y-6 border"
      >
        <h2 className="text-2xl font-bold text-center">
          Enter Your email address
        </h2>

        <div className="space-y-14">
          <label htmlFor="emailAddress" className="block">
            Email address:
          </label>
          <input
            type="text"
            name="emailAddress"
            id="emailAddress"
            placeholder="Please enter email Address"
            onChange={handleChange}
            className="w-full px-4 py-2 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>

        <button
          type="submit"
          className="w-full px-4 py-2 rounded-lg font-semibold"
        >
          Submit and Pay
        </button>
      </form>
    </div>
  );
}
