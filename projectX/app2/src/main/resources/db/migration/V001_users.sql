CREATE TABLE IF NOT EXISTS `users`(
    `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) DEFAULT 'testUser',
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `hashed_password` VARCHAR(255),
    `salt` VARCHAR(255)
)


