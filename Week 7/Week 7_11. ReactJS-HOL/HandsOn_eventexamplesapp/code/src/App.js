import React, { useState } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {
  const [count, setCount] = useState(1);

  // Handle Increment - Calls two functions
  const handleIncrement = () => {
    increment();
    sayHello();
  };

  const increment = () => {
    setCount(count + 1);
  };

  const sayHello = () => {
    console.log("Hello from Increment function!");
  };

  const handleDecrement = () => {
    setCount(count - 1);
  };

  // Welcome Message
  const sayWelcome = (msg) => {
    alert(msg);
  };

  // Synthetic Event
  const handleSyntheticClick = () => {
    alert("I was clicked");
  };

  return (
    <div style={{ fontFamily: "Arial" }}>
      <h1>{count}</h1>

      <button onClick={handleIncrement}>Increment</button>
      <br></br>
      <br />
      <button onClick={handleDecrement}>Decrement</button>
      <br></br>
      <br />
      <button onClick={() => sayWelcome("Welcome")}>Say welcome</button>
      <br></br>
      <br />
      <button onClick={handleSyntheticClick}>click me</button>

      <hr />

      <CurrencyConvertor />
    </div>
  );
}

export default App;
