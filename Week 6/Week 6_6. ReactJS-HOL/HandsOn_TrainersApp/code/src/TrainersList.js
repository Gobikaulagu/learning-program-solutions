// src/TrainersList.js
import React from "react";
import { Link } from "react-router-dom";

function TrainersList({ trainers }) {
  return (
    <div>
      <h2>List of Trainers</h2>
      <ul>
        {trainers.map((trainer) => (
          <li key={trainer.trainerId}>
            <Link to={`/trainers/${trainer.trainerId}`}>{trainer.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TrainersList;
