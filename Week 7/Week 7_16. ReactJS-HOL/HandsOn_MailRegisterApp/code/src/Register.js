import React, { useState } from "react";

const Register = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
  });

  const [errors, setErrors] = useState({});

  const validate = () => {
    const newErrors = {};

    if (formData.name.length < 5) {
      newErrors.name = "Name must be at least 5 characters";
    }

    if (!formData.email.includes("@") || !formData.email.includes(".")) {
      newErrors.email = "Email must contain @ and .";
    }

    if (formData.password.length < 8) {
      newErrors.password = "Password must be at least 8 characters";
    }

    setErrors(newErrors);

    // If no errors, return true
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert("Registration successful!");
      setFormData({ name: "", email: "", password: "" });
      setErrors({});
    }
  };

  return (
    <div style={styles.container}>
      <h2 style={{ color: "red" }}>Register Form!!!</h2>
      <form onSubmit={handleSubmit} style={styles.form}>
        <label>Name:</label>
        <input
          type="text"
          name="name"
          value={formData.name}
          onChange={handleChange}
          placeholder="Enter your name"
        />
        {errors.name && <span style={styles.error}>{errors.name}</span>}

        <label>Email:</label>
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
          placeholder="Enter your email"
        />
        {errors.email && <span style={styles.error}>{errors.email}</span>}

        <label>Password:</label>
        <input
          type="password"
          name="password"
          value={formData.password}
          onChange={handleChange}
          placeholder="Enter your password"
        />
        {errors.password && <span style={styles.error}>{errors.password}</span>}

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
  error: {
    color: "red",
    fontSize: "14px",
  },
};

export default Register;
