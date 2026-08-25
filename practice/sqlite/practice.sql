-- name*, username*, email, age, created_at
-- CREATE TABLE users (
--     id INTEGER PRIMARY KEY,
--     name TEXT NOT NULL, -- required field
--     username TEXT NOT NULL UNIQUE, -- required field and must be unique
--     email TEXT,
--     age INTEGER,
--     created_at DATETIME DEFAULT CURRENT_TIMESTAMP
-- );

-- retrieve all columns from users
--SELECT * FROM users

-- edit users by adding new text column called password
--ALTER TABLE users ADD COLUMN password TEXT;

-- delete users table
--DROP TABLE users;

-- insert new user with name 'Duy Tran' and username 'notduey'
-- INSERT INTO users (name, username)
-- VALUES ('Duy Tran', 'notduey');

-- INSERT INTO users (name, username)
-- VALUES ('John Doe', 'jd123'), ('Jane Doe', 'jane321'), ('Bob Smith', 'bobs123');

-- retrieve user with username 'notduey'
-- SELECT * FROM users
-- WHERE username='notduey';

-- retrieve all users with names starting with 'J' and limit to 1 query
-- SELECT * FROM users
-- WHERE name LIKE 'J%'
--LIMIT 1;

-- update email for user with id 1 (Duy Tran)
--UPDATE users SET email='newemail@gmail.com' WHERE id = 1;

-- delete user with id 2
-- DELETE FROM users WHERE id = 2; 

-------------------------------------------------------------------------------------------------

-- CREATE TABLE posts (
--     id INTEGER PRIMARY KEY,
--     user_id INTEGER REFERENCES users(id), -- foreign key
--     title TEXT NOT NULL,
--     body TEXT NOT NULL
-- );

-- insert new post with user_id 4, title 'My first post', and body 'I'm Bob and this is my first post!'
-- INSERT INTO posts (user_id, title, body)
-- VALUES (4, 'My first post', 'I''m Bob and this is my first post!');

-- retrieve all columns from posts
-- * FROM posts;

-- retrieve all posts with body and username
-- SELECT p.body, u.username FROM posts p -- alius as p
-- JOIN users u ON p.user_id = u.id; -- alias as u, join on post user ids and user 

-- create a view (virtual table) of all posts with body and username
-- CREATE VIEW posts_info AS
--     SELECT p.body, u.username FROM posts p
--     JOIN users u ON p.user_id = u.id;

SELECT * FROM posts_info;

-- INSERT INTO posts (user_id, title, body)
-- VALUES (1, 'I'' the goat', 'I''m Duy and my first post is goated!');