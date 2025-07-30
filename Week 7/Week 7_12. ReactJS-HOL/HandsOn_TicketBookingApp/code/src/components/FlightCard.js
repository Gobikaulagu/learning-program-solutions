import React from "react";

const FlightCard = ({ flight }) => (
  <div style={{ border: "1px solid #ccc", padding: "10px", margin: "10px" }}>
    <h3>{flight.name}</h3>
    <p>
      From: {flight.from} → To: {flight.to}
    </p>
    <p>Price: ₹{flight.price}</p>
  </div>
);

export default FlightCard;
