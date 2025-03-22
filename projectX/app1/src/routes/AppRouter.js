import { Routes, Route,Router } from "react-router-dom";
import Home from "../components/Home";
import Counter from "../components/Counter";
const AppRouter = () => {
  return (
    <Routes>
      <Route path="/" Component={Home} />
      <Route path="/counter" Component={Counter}/>
    </Routes>
  );
};
export default AppRouter;
