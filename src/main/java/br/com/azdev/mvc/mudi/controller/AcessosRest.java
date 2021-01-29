package br.com.azdev.mvc.mudi.controller;

import br.com.azdev.mvc.mudi.interceptor.InterceptadorAcessos;
import br.com.azdev.mvc.mudi.interceptor.InterceptadorAcessos.Acesso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("acessos")
@RestController
public class AcessosRest {

    @GetMapping
    public List<Acesso> getAcessos(){
        return InterceptadorAcessos.acessos;
    }
}
