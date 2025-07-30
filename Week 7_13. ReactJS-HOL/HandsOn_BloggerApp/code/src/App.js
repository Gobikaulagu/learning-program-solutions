import React from "react";
import { books } from "./data/books";
import { blogs } from "./data/blogs";
import { courses } from "./data/courses";
import "./App.css";
function App() {
  const bookdet = books.map((book) => (
    <div key={book.id}>
      <strong>{book.bname}</strong>
      <p>{book.price}</p>
    </div>
  ));

  const content = blogs.map((blog) => (
    <div key={blog.id}>
      <strong>{blog.title}</strong>
      <p>
        <em>{blog.author}</em>
      </p>
      <p>{blog.body}</p>
    </div>
  ));

  const coursedet = courses.map((course) => (
    <div key={course.id}>
      <strong>{course.cname}</strong>
      <p>{course.date}</p>
    </div>
  ));

  return (
    <div>
      <div style={{ display: "flex", justifyContent: "space-around" }}>
        <div className="st2">
          <h1>Book Details</h1>
          {bookdet}
        </div>

        <div className="v1">
          <h1>Blog Details</h1>
          {content}
        </div>

        <div className="mystyle1">
          <h1>Course Details</h1>
          {coursedet}
        </div>
      </div>
    </div>
  );
}

export default App;
