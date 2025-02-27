import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App";
import CheckDivisibility from "./components/CheckDivisibility";
import CheckGovernmentCards from "./components/CheckGovernmentCards";
import StudentList from "./components/StudentList";
import Greeting from "./components/Greeting";
import Counter from "./components/Counter";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <App
      components={{
        "Check Divisibility": <CheckDivisibility />,
        "Check Government Cards": <CheckGovernmentCards />,
        "Student List": <StudentList />,
        "Greeting": <Greeting />,
        "Counter": <Counter />,
      }}
    />
  </StrictMode>
);
