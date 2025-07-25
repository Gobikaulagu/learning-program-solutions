// src/OnlineShopping.js
import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {
  constructor(props) {
    super(props);

    this.state = {
      cartItems: [
        new Cart("Laptop", 60000),
        new Cart("Headphones", 1500),
        new Cart("Smartphone", 25000),
        new Cart("Keyboard", 1000),
        new Cart("Monitor", 7000),
      ],
    };
  }

  render() {
    const centerStyle = {
      display: "flex",
      flexDirection: "column",
      alignItems: "center",
      justifyContent: "center",
      color: "green",
      fontWeight: "bold",
      fontFamily: "Arial",
    };

    return (
      <div style={centerStyle}>
        <h2>Items ordered</h2>
        <table border="1" cellPadding="10" cellSpacing="0">
          <thead>
            <tr>
              <th>Item Name</th>
              <th>Price (₹)</th>
            </tr>
          </thead>
          <tbody>
            {this.state.cartItems.map((item, index) => (
              <tr key={index}>
                <td>{item.itemname}</td>
                <td>{item.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
