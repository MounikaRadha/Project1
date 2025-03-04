CREATE TABLE IF NOT EXISTS `posted_data`(
                                            `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
    `endpoint` VARCHAR(255),
    `posted_by` INT(10) ,
    `post_data` VARCHAR(255),
    `tags` TEXT DEFAULT NULL,
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `fk_postedBy_createdUser_constrain` FOREIGN KEY (`posted_by`) REFERENCES `users` (`id`) ON DELETE  NO ACTION
    )

