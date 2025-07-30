import React from "react";

const ListofPlayers = () => {
  // 1. Array of 11 players with names and scores
  const players = [
    { name: "Virat", score: 85 },
    { name: "Rohit", score: 65 },
    { name: "Dhoni", score: 90 },
    { name: "Bumrah", score: 45 },
    { name: "Kohli", score: 100 },
    { name: "Jadeja", score: 55 },
    { name: "Gill", score: 72 },
    { name: "Rahul", score: 62 },
    { name: "Ashwin", score: 77 },
    { name: "Shami", score: 66 },
    { name: "Pant", score: 59 },
  ];

  // 2. Filter players with score < 70
  const filteredPlayers = players.filter((player) => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>

      <h3>List of Players having scores less than 70:</h3>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
