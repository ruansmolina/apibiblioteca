CREATE TABLE IF NOT EXISTS `apibiblioteca`.`Categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `apibiblioteca`.`Autor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `apibiblioteca`.`Livro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `isbn` VARCHAR(13) NOT NULL,
  `ano_publicacao` VARCHAR(4) NULL,
  `autor_id` INT NULL,
  `categoria_id` INT NULL,
  `quantidade_total` INT NOT NULL,
  `quatidade_disponivel` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_categoria_id_idx` (`categoria_id` ASC) VISIBLE,
  INDEX `fk_autor_id_idx` (`autor_id` ASC) VISIBLE,
  CONSTRAINT `fk_categoria_id`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `apibiblioteca`.`Categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autor_id`
    FOREIGN KEY (`autor_id`)
    REFERENCES `apibiblioteca`.`Autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);