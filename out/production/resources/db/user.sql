CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL,
                      email VARCHAR(100),
                      phone VARCHAR(20) NOT NULL
);
