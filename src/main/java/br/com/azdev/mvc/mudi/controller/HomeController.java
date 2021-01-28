package br.com.azdev.mvc.mudi.controller;

import br.com.azdev.mvc.mudi.model.Pedido;
import br.com.azdev.mvc.mudi.model.StatusPedido;
import br.com.azdev.mvc.mudi.model.User;
import br.com.azdev.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model){
        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(0, 10, sort);
        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }
}
