-- Create database (if not already created)
CREATE DATABASE IF NOT EXISTS ormlearn;

-- Use the schema
USE ormlearn;

-- Create the country table
CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50)
);

-- Insert sample data
INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');
