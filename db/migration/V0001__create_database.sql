CREATE TABLE `CarrinhoCompra` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idUsuario` bigint NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `Produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idProdutoService` bigint NOT NULL,
  `valor` double NOT NULL,
  `idCarrinho` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Produto_1_idx` (`idCarrinho`),
  CONSTRAINT `fk_Produto_1` FOREIGN KEY (`idCarrinho`) REFERENCES `CarrinhoCompra` (`id`)
);