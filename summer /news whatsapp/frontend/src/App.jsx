import { useState } from "react";
import MyNavbar from "./components/MyNavbar";
import MyFooter from "./components/MyFooter";
import MyMainDiv from "./components/MyMainDiv";
import "./App.css";
function App() {
  return (
    <div className="flex flex-col h-screen w-screen">
      <div className="flex-none">
        <MyNavbar />
      </div>
      <div className="flex-grow">
        <MyMainDiv />
      </div>
      <div className="flex-none">
        <MyFooter />
      </div>
    </div>
  );
}

export default App;
