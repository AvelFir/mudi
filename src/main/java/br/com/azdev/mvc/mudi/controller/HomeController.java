package br.com.azdev.mvc.mudi.controller;

import br.com.azdev.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/home")

    public String home(Model model){
        Pedido pedido = new Pedido();
        pedido.setNome("Echo Dot");
        pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/61a%2BK6x-RML._AC_SL1000_.jpg");
        pedido.setUrlProduto("https://www.amazon.com.br/gp/product/B084DWCZY6/?pf_rd_r=EDX5VZFY7GPF50FQRHDH&pf_rd_p=5d8f5ea6-a0a3-4bb0-aa59-ddde156f6b37");
        pedido.setDescricao("Descrição Qualquer");
        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
