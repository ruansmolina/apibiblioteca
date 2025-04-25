CREATE TABLE IF NOT EXISTS `apibiblioteca`.`Usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `tipo` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))