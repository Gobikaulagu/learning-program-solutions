import React from "react";

const IndianPlayers = () => {
  const allPlayers = ["Virat", "Rohit", "Dhoni", "Bumrah", "Kohli", "Jadeja"];

  // a. Destructuring odd and even players
  const oddPlayers = allPlayers.filter((_, index) => index % 2 === 0);
  const evenPlayers = allPlayers.filter((_, index) => index % 2 !== 0);

  // b. Merge two arrays using ES6 spread operator
  const T20players = ["Gill", "Suryakumar", "Hardik"];
  const RanjiTrophy = ["Pujara", "Rahane", "Iyer"];
  const mergedPlayers = [...T20players, ...RanjiTrophy];

  return (
    <div>
      <h2>Odd Players</h2>
      <ul>
        {oddPlayers.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>

      <h2> Even Players</h2>
      <ul>
        {evenPlayers.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>

      <h2>List of Indian players merged</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
