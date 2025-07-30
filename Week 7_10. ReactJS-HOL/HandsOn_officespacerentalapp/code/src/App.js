import React from "react";
import officeImage from "./office.jpg";
function App() {
  const office = {
    name: "DBS",
    rent: 50000,
    address: "Chennai",
    image: officeImage,
  };

  const rentStyle = {
    color: office.rent < 60000 ? "red" : "green",
    fontWeight: "bold",
  };

  return (
    <div style={{ textAlign: "center", fontFamily: "Arial" }}>
      <h1>Office Space , at Affordable Range</h1>

      <img
        src={office.image}
        alt="Office"
        style={{ width: "300px", height: "200px", borderRadius: "8px" }}
      />

      <h2 style={{ textAlign: "left", marginLeft: "35%" }}>
        Name: {office.name}
      </h2>

      <p style={{ ...rentStyle, textAlign: "left", marginLeft: "35%" }}>
        Rent: Rs. {office.rent}
      </p>

      <p style={{ textAlign: "left", marginLeft: "35%" }}>
        Address: {office.address}
      </p>
    </div>
  );
}

export default App;
