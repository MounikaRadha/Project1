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
    console.log("email address: " + emailAddress);
    const res = await requests.get(
      URL_CONSTANTS.CREATE_ORDER_ENDPOINT,
      emailAddress
    );
    const options = {
      key: import.meta.env.VITE_RAZOR_KEY_ID, // Enter the Key ID generated from the Dashboard
      amount: "50000", // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
      currency: "INR",
      name: "Acme Corp", //your business name
      description: "Test Transaction",
      image: "https://example.com/your_logo",
      order_id: res.id, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
      handler: function (response) {
        alert(response.razorpay_payment_id);
        alert(response.razorpay_order_id);
        alert(response.razorpay_signature);
      },
      prefill: {
        //We recommend using the prefill parameter to auto-fill customer's contact information, especially their phone number
        name: "Gaurav Kumar", //your customer's name
        email: "gaurav.kumar@example.com",
        contact: "9000090000", //Provide the customer's phone number for better conversion rates
      },
      notes: {
        address: "Razorpay Corporate Office",
      },
      theme: {
        color: "#3399cc",
      },
    };
    const rzp1 = new window.Razorpay(options);
    rzp1.on("payment.failed", function (response) {
      alert(response.error.code);
      alert(response.error.description);
      alert(response.error.source);
      alert(response.error.step);
      alert(response.error.reason);
      alert(response.error.metadata.order_id);
      alert(response.error.metadata.payment_id);
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
            className="w-full px-4 py-2 rounded-lg text-black focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>

        <button
          type="submit"
          className="w-full px-4 py-2 rounded-lg font-semibold"
        >
          Submit and pay
        </button>
      </form>
    </div>
  );
}
