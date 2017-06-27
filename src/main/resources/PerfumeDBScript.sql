SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema PerfumeDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PerfumeDB` ;

-- -----------------------------------------------------
-- Schema PerfumeDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PerfumeDB` DEFAULT CHARACTER SET utf8 ;
USE `PerfumeDB` ;

-- -----------------------------------------------------
-- Table `PerfumeDB`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PerfumeDB`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL DEFAULT 'Unknown',
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `PerfumeDB`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `PerfumeDB`.`user_roles` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,

  FOREIGN KEY (`user_id`) REFERENCES `PerfumeDB`.`users`(`id`),
  FOREIGN KEY (`role_id`) REFERENCES `PerfumeDB`.`roles`(`id`),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PerfumeDB`.`Cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PerfumeDB`.`Cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_user_idx` (`id_user` ASC),
  CONSTRAINT `id_user`
  FOREIGN KEY (`id_user`)
  REFERENCES `PerfumeDB`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PerfumeDB`.`Brands`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PerfumeDB`.`Brands` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT 'Unknown Brand',
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PerfumeDB`.`Perfumes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PerfumeDB`.`Perfumes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT 'Unknown Perfume',
  `id_brand` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `brand_id_idx` (`id_brand` ASC),
  CONSTRAINT `id_brand`
  FOREIGN KEY (`id_brand`)
  REFERENCES `PerfumeDB`.`Brands` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PerfumeDB`.`Offers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PerfumeDB`.`Offers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price_per_ml` INT NULL,
  `volume_ml` INT NULL,
  `id_perfume` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `perfume_id_idx` (`id_perfume` ASC),
  CONSTRAINT `id_perfume`
  FOREIGN KEY (`id_perfume`)
  REFERENCES `PerfumeDB`.`Perfumes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `PerfumeDB`.`submittedOrders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `total_price` INT NULL,
  `id_user` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_user_idx` (`id_user` ASC),
  CONSTRAINT `id_userOrders`
  FOREIGN KEY (`id_user`)
  REFERENCES `PerfumeDB`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `PerfumeDB`.`Sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PerfumeDB`.`Sales` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `volume_ordered_ml` INT NULL,
  `id_cart` INT NULL,
  `id_offer` INT NULL,
  `id_submittedOrder` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_cart_idx` (`id_cart` ASC),
  INDEX `id_offer_idx` (`id_offer` ASC),
  INDEX `id_submittedOrder_idx` (`id_submittedOrder` ASC),
  CONSTRAINT `id_cart`
  FOREIGN KEY (`id_cart`)
  REFERENCES `PerfumeDB`.`Cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_offer`
  FOREIGN KEY (`id_offer`)
  REFERENCES `PerfumeDB`.`Offers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `id_submittedOrder`
    FOREIGN KEY (`id_submittedOrder`)
  REFERENCES `PerfumeDB`.`submittedOrders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;