package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
