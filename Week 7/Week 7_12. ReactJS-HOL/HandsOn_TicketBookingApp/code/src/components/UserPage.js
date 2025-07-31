import React from "react";
import FlightCard from "./FlightCard";

const flights = [
  { name: "IndiGo 202", from: "Chennai", to: "Bangalore", price: 3200 },
  { name: "Air India 101", from: "Delhi", to: "Mumbai", price: 4500 },
];

const UserPage = () => (
  <div>
    <h2>Welcome Back, User!</h2>
    {flights.map((flight, index) => (
      <div key={index}>
        <FlightCard flight={flight} />
        <button>Book Ticket</button>
      </div>
    ))}
  </div>
);

export default UserPage;
