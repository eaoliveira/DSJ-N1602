CREATE SCHEMA IF NOT EXISTS `cadastro` DEFAULT CHARACTER SET latin1 ;
USE `cadastro` ;

-- -----------------------------------------------------
-- Table `cadastro`.`fone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastro`.`fone` ;

CREATE  TABLE IF NOT EXISTS `cadastro`.`fone` (
  `idfone` INT NOT NULL AUTO_INCREMENT ,
  `ddd` VARCHAR(2) NOT NULL ,
  `numero` VARCHAR(10) NOT NULL ,
  `tipo` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`idfone`) )
ENGINE = InnoDB;