ALTER TABLE `users`
    ADD `hashed_password` VARCHAR(255);
ALTER TABLE `users`
    ADD `salt` VARCHAR(255);
