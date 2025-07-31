import React from "react";
import "../Stylesheets/mystyle.css";

function CalculateScore() {
  const name = "Steeve";
  const school = "DNV Public School";
  const total = 284;
  const maxMarks = 300;
  const score = ((total / maxMarks) * 100).toFixed(2);

  return (
    <div className="student-container">
      <h2>Student Details:</h2>
      <p>
        <span className="label name">Name:</span>{" "}
        <span className="value name-value">{name}</span>
      </p>
      <p>
        <span className="label school">School:</span> {school}
      </p>
      <p>
        <span className="label total">Total:</span> {total} Marks
      </p>
      <p>
        <span className="label score">Score:</span>
        {score}%
      </p>
    </div>
  );
}

export default CalculateScore;
