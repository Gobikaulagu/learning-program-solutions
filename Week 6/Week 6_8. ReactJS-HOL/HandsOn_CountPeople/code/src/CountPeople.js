import React, { Component } from "react";

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entryCount: 0,
      exitCount: 0,
    };
  }

  UpdateEntry = () => {
    this.setState((prevState) => ({
      entryCount: prevState.entryCount + 1,
    }));
  };

  UpdateExit = () => {
    this.setState((prevState) => ({
      exitCount: prevState.exitCount + 1,
    }));
  };

  render() {
    const containerStyle = {
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      minHeight: "100vh",
      fontFamily: "Arial, sans-serif",
      backgroundColor: "#f0f0f0",
    };

    const contentWrapperStyle = {
      display: "flex",
      gap: "50px", // Space between the "Login" and "Exit" elements
    };

    const itemStyle = {
      display: "flex",
      alignItems: "center",
    };

    const buttonStyle = {
      padding: "8px 15px",
      fontSize: "16px",
      cursor: "pointer",
      border: "1px solid #4CAF50",
      borderRadius: "4px",
      backgroundColor: "#4CAF50",
      color: "white",
      fontWeight: "bold",
    };

    const textStyle = {
      fontSize: "18px",
      fontWeight: "normal",
      color: "#333",
      marginLeft: "10px", // Space between button and text
    };

    return (
      <div style={containerStyle}>
        <div style={contentWrapperStyle}>
          {/* Login Item */}
          <div style={itemStyle}>
            <button onClick={this.UpdateEntry} style={buttonStyle}>
              Login
            </button>
            <span style={textStyle}>
              {this.state.entryCount} People Entered!!!
            </span>
          </div>

          {/* Exit Item */}
          <div style={itemStyle}>
            <button onClick={this.UpdateExit} style={buttonStyle}>
              Exit
            </button>
            <span style={textStyle}>{this.state.exitCount} People Left!!!</span>
          </div>
        </div>
      </div>
    );
  }
}

export default CountPeople;
