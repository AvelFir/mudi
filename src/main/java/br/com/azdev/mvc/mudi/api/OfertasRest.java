package br.com.azdev.mvc.mudi.api;

import br.com.azdev.mvc.mudi.dto.OfertaDTO;
import br.com.azdev.mvc.mudi.model.Oferta;
import br.com.azdev.mvc.mudi.model.Pedido;
import br.com.azdev.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(@Valid @RequestBody OfertaDTO requisicao){
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
        if(pedidoBuscado.isEmpty()){
            return null;
        }
        Pedido pedido = pedidoBuscado.get();
        Oferta nova = requisicao.toOferta();
        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);
        pedidoRepository.save(pedido);
        return nova;
        }
}

