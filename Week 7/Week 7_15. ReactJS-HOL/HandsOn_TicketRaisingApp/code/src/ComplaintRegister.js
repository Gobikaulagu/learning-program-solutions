import React, { useState } from "react";

const ComplaintRegister = () => {
  const [name, setName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!name || !complaint) {
      alert("Please fill out both fields.");
      return;
    }

    const referenceNumber = "REF" + Math.floor(Math.random() * 1000000);

    alert(
      `Complaint registered successfully!\nEmployee: ${name}\nReference No: ${referenceNumber}`
    );

    // Reset form
    setName("");
    setComplaint("");
  };

  return (
    <div style={styles.container}>
      <h2 style={{ color: "red" }}>Register your Complaints here!!!</h2>
      <form onSubmit={handleSubmit} style={styles.form}>
        <label>Name:</label>
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Enter your name"
          required
        />

        <label>Complaint:</label>
        <textarea
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
          placeholder="Describe your complaint"
          required
        ></textarea>

        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

const styles = {
  container: {
    width: "400px",
    margin: "50px auto",
    padding: "20px",
  },
  form: {
    display: "flex",
    flexDirection: "column",
    gap: "10px",
  },
};

export default ComplaintRegister;
