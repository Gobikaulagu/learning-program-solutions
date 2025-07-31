// src/TrainersMock.js
import Trainer from "./Trainer";

const trainers = [
  new Trainer(1, "John Doe", "john@example.com", "9876543210", "Java", [
    "Spring",
    "Hibernate",
  ]),
  new Trainer(2, "Jane Smith", "jane@example.com", "8765432109", "Python", [
    "Django",
    "Flask",
  ]),
  new Trainer(
    3,
    "Alice Johnson",
    "alice@example.com",
    "7654321098",
    "JavaScript",
    ["React", "Node.js"]
  ),
];

export default trainers;
