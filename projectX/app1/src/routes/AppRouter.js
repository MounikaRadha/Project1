import { Routes, Route,Router } from "react-router-dom";
import Home from "../components/Home";
import Counter from "../components/Counter";
import UsersComponent from "../components/Users/UsersComponent";
import EndPointComponent from "../components/Endpoints/EndPointComponent";
const AppRouter = () => {
  return (
    <Routes>
      <Route path="/" Component={Home} />
      <Route path="/counter" Component={Counter}/>
      <Route path="/users" Component={UsersComponent}/>
      <Route path="/endpoint" Component={EndPointComponent}/>
    </Routes>
  );
};
export default AppRouter;
