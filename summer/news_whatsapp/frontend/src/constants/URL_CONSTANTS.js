// const BACKEND_URL=import.meta.env.VITE_BACKEND_URL;
const BACKEND_URL="https://news.radha-mounika.com"
const CREATE_ORDER_ENDPOINT = "/createOrder"; //to create a order using which we open razorpay payment gateway we give email and get order id
const HANDLE_PAYMENT_ENDPOINT = "/handlePayment"; //once payment gateway is finshed and closed we send the order id payment id ,email address,signature to the backend to verify the payment and send the status message to the frontend
const URL_CONSTANTS = {
  BACKEND_URL,
  CREATE_ORDER_ENDPOINT,
  HANDLE_PAYMENT_ENDPOINT,
};
export default URL_CONSTANTS;
