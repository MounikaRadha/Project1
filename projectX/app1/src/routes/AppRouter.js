import { Routes, Route, Router } from "react-router-dom";
import Home from "../components/Home";
import Counter from "../components/Counter";
import UsersComponent from "../components/Users/UsersComponent";
import EndPointComponent from "../components/Endpoints/EndPointComponent";
import PostedDataComponent from "../components/PostedData/PostedDataComponent";
import Navbar from "../components/Navbar";
import URL_Constants from "../constants/Url_Constants";
const AppRouter = () => {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" Component={Home} />
        <Route path="/counter" Component={Counter} />
        <Route path={URL_Constants.USERS_PATH} Component={UsersComponent} />
        <Route
          path={URL_Constants.END_POINTS_PATH}
          Component={EndPointComponent}
        />
        <Route
          path={URL_Constants.POSTED_DATA_PATH}
          Component={PostedDataComponent}
        />
        <Route path="*" Component={Home} />
        <Route path="/" Component={Home} />
        <Route path="" Component={Home} />
      </Routes>
    </>
  );
};
export default AppRouter;
