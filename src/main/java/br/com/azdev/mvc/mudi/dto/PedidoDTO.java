package br.com.azdev.mvc.mudi.dto;

import br.com.azdev.mvc.mudi.model.Pedido;
import br.com.azdev.mvc.mudi.model.StatusPedido;
import br.com.azdev.mvc.mudi.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String nomeProduto;
    @JsonProperty
    private BigDecimal valorProduto;
    @JsonProperty
    private LocalDate dataEntrega;
    @JsonProperty
    private String urlProduto;
    @JsonProperty
    private String urlImagem;
    @JsonProperty
    private String descricao;
    @JsonProperty
    private StatusPedido status;
    @JsonProperty
    private String user;

    public  PedidoDTO(Pedido pedido){
        this.id = pedido.getId();
        this.nomeProduto = pedido.getNomeProduto();
        this.urlProduto = pedido.getUrlProduto();
        this.urlImagem = pedido.getUrlImagem();
        this.descricao = pedido.getDescricao();
        this.status = pedido.getStatus();
        this.user = pedido.getUser().getUsername();
    }

    public PedidoDTO(){}
}
