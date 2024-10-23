ALTER TABLE `Produto` 
DROP FOREIGN KEY `fk_Produto_1`;
ALTER TABLE `Produto` 
DROP COLUMN `idCarrinho`,
DROP INDEX `fk_Produto_1_idx` ;

CREATE TABLE `Item` (
  `idCarrinho` BIGINT NOT NULL,
  `idProduto` BIGINT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`idCarrinho`, `idProduto`),
  INDEX `fk_Item_2_idx` (`idProduto` ASC) VISIBLE,
  CONSTRAINT `fk_Item_1`
    FOREIGN KEY (`idCarrinho`)
    REFERENCES `CarrinhoCompra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_2`
    FOREIGN KEY (`idProduto`)
    REFERENCES `Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
