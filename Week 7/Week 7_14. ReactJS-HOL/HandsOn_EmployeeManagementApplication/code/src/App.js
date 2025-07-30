import "./App.css";
import { EmployeesData } from "./Employee";
import EmployeesList from "./EmployeesList";
import { useState } from "react";
import ThemeContext from "./ThemeContext";

function App() {
  const [theme, setTheme] = useState("light");
  const Employees = EmployeesData;

  return (
    <ThemeContext.Provider value={theme}>
      {" "}
      {/*  wrap in context */}
      <div>
        <label>SELECT A THEME </label>
        <select onChange={(e) => setTheme(e.target.value)}>
          <option value="light">Light</option>
          <option value="dark">Dark</option>
        </select>
      </div>
      <EmployeesList employees={Employees} /> {/* no more theme prop */}
    </ThemeContext.Provider>
  );
}

export default App;
