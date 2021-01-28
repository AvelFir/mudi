package br.com.azdev.mvc.mudi.controller;

import br.com.azdev.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.azdev.mvc.mudi.model.Pedido;
import br.com.azdev.mvc.mudi.repository.PedidoRepository;
import br.com.azdev.mvc.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result){
        if(result.hasErrors()){
            return "pedido/formulario";
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Pedido pedido = requisicao.toPedido();
        pedido.setUser(userRepository.findByUsername(username));
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
