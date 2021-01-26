package br.com.azdev.mvc.mudi.repository;

import br.com.azdev.mvc.mudi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
