import React, { useState } from "react";

function CurrencyConvertor() {
  const [amount, setAmount] = useState("");
  const [currency, setCurrency] = useState("Euro");

  const handleSubmit = () => {
    if (currency === "Euro") {
      // Your example assumes 1 Euro = 80 INR, so conversion is: INR * 80
      const converted = amount * 80;
      alert(`Converting to  ${currency} Amount is ${converted}`);
    }
  };

  return (
    <div style={{ textAlign: "left", marginLeft: "40px", fontFamily: "Arial" }}>
      <h2 style={{ color: "green", fontWeight: "bold" }}>
        Currency Convertor!!!
      </h2>

      <p>
        <label>Amount: </label>
        <input
          type="number"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />
      </p>

      <p>
        <label>Currency: </label>
        <select value={currency} onChange={(e) => setCurrency(e.target.value)}>
          <option value="Euro">Euro</option>
        </select>
      </p>

      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default CurrencyConvertor;
