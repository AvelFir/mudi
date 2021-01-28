package br.com.azdev.mvc.mudi.api;

import br.com.azdev.mvc.mudi.dto.PedidoDTO;
import br.com.azdev.mvc.mudi.model.Pedido;
import br.com.azdev.mvc.mudi.model.StatusPedido;
import br.com.azdev.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("aguardando")
    public List<PedidoDTO> getPedidoAguardandoOfertas(){
        List<PedidoDTO> pedidosDTO = new ArrayList<>(Collections.emptyList());
        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(0, 10, sort);
        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
        for(Pedido pedido: pedidos){
            PedidoDTO pedidoDTO = new PedidoDTO(pedido);
            pedidosDTO.add(pedidoDTO);
        }
        return pedidosDTO;
    }
}
