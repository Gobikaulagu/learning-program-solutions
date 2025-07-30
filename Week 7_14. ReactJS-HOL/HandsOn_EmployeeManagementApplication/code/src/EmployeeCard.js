import { useContext } from "react";
import ThemeContext from "./ThemeContext"; // ✅ import
import Styles from "./EmployeeCard.module.css";

function EmployeeCard(props) {
  const theme = useContext(ThemeContext); // ✅ get current theme

  return (
    <div className={Styles.Card}>
      <h3>{props.employee.name}</h3>
      <p>{props.employee.email}</p>
      <p>{props.employee.phone}</p>
      <p>
        <button className={theme}>Edit</button>
        <button className={theme}>Delete</button>
      </p>
    </div>
  );
}

export default EmployeeCard;
