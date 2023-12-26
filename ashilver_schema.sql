-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ash
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ash
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ash` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ash` ;

-- -----------------------------------------------------
-- Table `ash`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`board` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ash`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`board_post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `board_id` INT NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `reg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `view_cnt` INT NOT NULL DEFAULT '0',
  `image` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_board_post_board1_idx` (`board_id` ASC) VISIBLE,
  INDEX `fk_board_post_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_board_post_board1`
    FOREIGN KEY (`board_id`)
    REFERENCES `ash`.`board` (`id`),
  CONSTRAINT `fk_board_post_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ash`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ash`.`board_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`board_review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `post_id` INT NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `reg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_board_review_post1_idx` (`post_id` ASC) VISIBLE,
  INDEX `fk_board_review_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_board_review_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `ash`.`board_post` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_board_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ash`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ash`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`user` (
  `id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `image` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ash`.`friendship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`friendship` (
  `user1_id` VARCHAR(45) NOT NULL,
  `user2_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user1_id`, `user2_id`),
  INDEX `fk_friendship_user1_idx` (`user2_id` ASC) VISIBLE,
  CONSTRAINT `fk_friendship_user`
    FOREIGN KEY (`user1_id`)
    REFERENCES `ash`.`user` (`id`),
  CONSTRAINT `fk_friendship_user1`
    FOREIGN KEY (`user2_id`)
    REFERENCES `ash`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ash`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `reg_date` DATE NOT NULL DEFAULT (now()),
  `leader` VARCHAR(45) NOT NULL,
  `intro` text NULL,
  `image` TEXT Null DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ash`.`group_board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`group_post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_id` INT NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `reg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `view_cnt` INT NOT NULL DEFAULT '0',
  `image` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_group_post_group1_idx` (`group_id` ASC) VISIBLE,
  INDEX `fk_group_post_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_group_post_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `ash`.`group` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_group_post_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ash`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ash`.`group_post_check`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`post_check` (
  `user_id` VARCHAR(45) NOT NULL,
  `post_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `post_id`),
  INDEX `fk_post_check_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_post_check_post1_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `fk_post_check_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `ash`.`group_post` (`id`),
  CONSTRAINT `fk_post_check_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ash`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ash`.`group_board_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`group_review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `post_id` INT NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `reg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_group_review_post1_idx` (`post_id` ASC) VISIBLE,
  INDEX `fk_group_review_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_group_review_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `ash`.`group_post` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_group_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ash`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ash`.`group_membership`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`group_membership` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `group_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_group_membership_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_group_membership_group1_idx` (`group_id` ASC) VISIBLE,
  CONSTRAINT `fk_group_membership_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `ash`.`group` (`id`),
  CONSTRAINT `fk_group_membership_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ash`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ash`.`betting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ash`.`betting` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `keyword` VARCHAR(45) NOT NULL,
  `goal` VARCHAR(45) NOT NULL,
  `award` VARCHAR(45) NOT NULL,
  `fee` VARCHAR(45) NOT NULL,
  `start` DATE NOT NULL DEFAULT (NOW()),
  `end` DATE NOT NULL DEFAULT (NOW() + INTERVAL 1 MONTH),
  PRIMARY KEY (`id`),
  INDEX `fk_betting_group1_idx` (`group_id` ASC) VISIBLE,
  CONSTRAINT `fk_betting_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `ash`.`group` (`id`)
	ON DELETE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
