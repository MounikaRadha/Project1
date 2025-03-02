CREATE TABLE IF NOT EXISTS `end_points`(
                                           `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
    `endpoint` VARCHAR(255) UNIQUE,
    `owned_by` INT(10),
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `fk_users_endpoints_createdBy_constrain` FOREIGN KEY (`owned_by`) REFERENCES `users` (`id`) ON DELETE NO ACTION
    )