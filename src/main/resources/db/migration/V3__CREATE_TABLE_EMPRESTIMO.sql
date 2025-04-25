CREATE TABLE IF NOT EXISTS `apibiblioteca`.`Emprestimo` (
  `Usuario_id` INT NOT NULL,
  `Livro_id` INT NOT NULL,
  `id` INT NOT NULL,
  `data_emprestimo` DATETIME NOT NULL,
  `data_devolucao` DATETIME NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_id_idx` (`Usuario_id` ASC) INVISIBLE,
  INDEX `fk_livro_id_idx` (`Livro_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_id`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `apibiblioteca`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livro_id`
    FOREIGN KEY (`Livro_id`)
    REFERENCES `apibiblioteca`.`Livro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)