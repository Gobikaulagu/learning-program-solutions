// src/Posts.js
import React, { Component } from "react";
import Post from "./Post";

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  // 6. Fetch posts using fetch API
  loadPosts() {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => response.json())
      .then((data) => {
        const postObjects = data.map((p) => new Post(p.id, p.title, p.body));
        this.setState({ posts: postObjects });
      })
      .catch((error) => {
        console.error("Error fetching posts:", error);
      });
  }

  // 7. Lifecycle method
  componentDidMount() {
    this.loadPosts();
  }

  // 9. Error handler
  componentDidCatch(error, info) {
    alert("An error occurred in Posts component.");
    console.error(error, info);
  }

  // 8. Render posts
  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h1>Blog Posts</h1>
        {this.state.posts.map((post) => (
          <div key={post.id} style={{ marginBottom: "20px" }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
