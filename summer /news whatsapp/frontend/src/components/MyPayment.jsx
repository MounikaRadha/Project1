import requests from "../api/requests";
import URL_CONSTANTS from "../constants/URL_CONSTANTS";
export default function MyPayment() {
  const handleSubmit = (e) => {
    e.preventDefault();
    requests.post(URL_CONSTANTS.PAYMENT_ENDPOINT);
  };

  return (
    <div className="min-h-screen flex items-center justify-center">
      <form
        onSubmit={handleSubmit}
        className=" p-8 rounded-2xl  w-full max-w-md space-y-6 border"
      >
        <h2 className="text-2xl font-bold text-center">
         payment page
        </h2>

        <div className="space-y-14">
          <label htmlFor="emailAddress" className="block">
           Email address:
          </label>
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
