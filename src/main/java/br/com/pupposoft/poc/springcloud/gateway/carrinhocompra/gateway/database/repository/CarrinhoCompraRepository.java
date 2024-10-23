package br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pupposoft.poc.springcloud.gateway.carrinhocompra.gateway.database.entity.CarrinhoCompraEntity;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompraEntity, Long> {

}
