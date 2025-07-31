import React from "react";
import FlightCard from "./FlightCard";

const flights = [
  { name: "IndiGo 202", from: "Chennai", to: "Bangalore", price: 3200 },
  { name: "Air India 101", from: "Delhi", to: "Mumbai", price: 4500 },
];

const GuestPage = () => (
  <div>
    <h2>Welcome Guest!</h2>
    <p>Browse flights below. Please login to book tickets.</p>
    {flights.map((flight, index) => (
      <FlightCard key={index} flight={flight} />
    ))}
  </div>
);

export default GuestPage;
