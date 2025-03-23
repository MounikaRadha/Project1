import { Routes, Route,Router } from "react-router-dom";
import Home from "../components/Home";
import Counter from "../components/Counter";
import UsersComponent from "../components/Users/UsersComponent";
import EndPointComponent from "../components/Endpoints/EndPointComponent";
import PostedDataComponent from "../components/PostedData/PostedDataComponent";
import Navbar from "../components/Navbar/Navbar";
const AppRouter = () => {
  return (
    <>
    <Navbar/>
    <Routes>
      <Route path="/" Component={Home} />
      <Route path="/counter" Component={Counter}/>
      <Route path="/users" Component={UsersComponent}/>
      <Route path="/endpoint" Component={EndPointComponent}/>
      <Route path="/postedData" Component={PostedDataComponent}/>
    </Routes>
    </>
  );
};
export default AppRouter;
