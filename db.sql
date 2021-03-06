-- MySQL Script generated by MySQL Workbench
-- Sat Oct 31 03:27:41 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema assets
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema assets
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `assets` DEFAULT CHARACTER SET utf8 ;
USE `assets` ;

-- -----------------------------------------------------
-- Table `assets`.`asset_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assets`.`asset_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `state` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assets`.`physical_asset`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assets`.`physical_asset` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) BINARY NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `year` VARCHAR(4) NOT NULL,
  `quantity` INT NOT NULL,
  `assigned_assets` INT NOT NULL,
  `state` INT NOT NULL,
  `asset_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_physical_asset_asset_type_idx` (`asset_id` ASC) VISIBLE,
  CONSTRAINT `fk_physical_asset_asset_type`
    FOREIGN KEY (`asset_id`)
    REFERENCES `assets`.`asset_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assets`.`workers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assets`.`workers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` DATETIME NOT NULL,
  `state` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assets`.`assign_assets_workers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assets`.`assign_assets_workers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `physical_asset_id` INT NOT NULL,
  `workers_id` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_assign_assets_workers_physical_asset1_idx` (`physical_asset_id` ASC) VISIBLE,
  INDEX `fk_assign_assets_workers_workers1_idx` (`workers_id` ASC) VISIBLE,
  CONSTRAINT `fk_assign_assets_workers_physical_asset1`
    FOREIGN KEY (`physical_asset_id`)
    REFERENCES `assets`.`physical_asset` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_assign_assets_workers_workers1`
    FOREIGN KEY (`workers_id`)
    REFERENCES `assets`.`workers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
