SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `contato`.`Contato`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `contato`.`Contato` (
  `idContato` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(150) NOT NULL ,
  `idade` INT NOT NULL ,
  `email` VARCHAR(150) NOT NULL ,
  PRIMARY KEY (`idContato`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contato`.`Fone`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `contato`.`Fone` (
  `idFone` INT NOT NULL AUTO_INCREMENT ,
  `ddd` VARCHAR(3) NOT NULL ,
  `numero` VARCHAR(11) NOT NULL ,
  `idContato` INT NOT NULL ,
  PRIMARY KEY (`idFone`) ,
  INDEX `fk_Fone_Contato` (`idContato` ASC) ,
  CONSTRAINT `fk_Fone_Contato`
    FOREIGN KEY (`idContato` )
    REFERENCES `contato`.`Contato` (`idContato` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
