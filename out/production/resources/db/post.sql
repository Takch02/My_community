CREATE TABLE post (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(100) NOT NULL,
                      content TEXT NOT NULL,
                      created_at TIMESTAMP,
                      userid INT NOT NULL,
                      username VARCHAR(50) NOT NULL,
                      subtitle VARCHAR(100) NOT NULL,
                      FOREIGN KEY (userid) REFERENCES user(id)
);