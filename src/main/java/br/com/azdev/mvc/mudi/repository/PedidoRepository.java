package br.com.azdev.mvc.mudi.repository;

import br.com.azdev.mvc.mudi.model.Pedido;
import br.com.azdev.mvc.mudi.model.StatusPedido;
import br.com.azdev.mvc.mudi.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatusAndUser(StatusPedido status, User user);


    List<Pedido> findAllByUser(User user);

    @Cacheable("books")
    List<Pedido> findByStatus(StatusPedido statusPedido, Pageable sort);

    @Cacheable("books")
    List<Pedido> findByStatus(StatusPedido statusPedido);

}
