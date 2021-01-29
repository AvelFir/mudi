package br.com.azdev.mvc.mudi.dto;

import br.com.azdev.mvc.mudi.model.Pedido;
import br.com.azdev.mvc.mudi.model.StatusPedido;
import br.com.azdev.mvc.mudi.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoDTO {

    private Long id;
    @NotBlank
    private String nomeProduto;
    private BigDecimal valorProduto;
    private LocalDate dataEntrega;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    private String descricao;
    private StatusPedido status;
    private String user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public  PedidoDTO(Pedido pedido){
        this.id = pedido.getId();
        this.nomeProduto = pedido.getNomeProduto();
        this.urlProduto = pedido.getUrlProduto();
        this.urlImagem = pedido.getUrlImagem();
        this.descricao = pedido.getDescricao();
        this.status = pedido.getStatus();
        this.user = pedido.getUser().getUsername();
    }
    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(getNomeProduto());
        pedido.setDescricao(getDescricao());
        pedido.setUrlProduto(getUrlProduto());
        pedido.setUrlImagem(getUrlImagem());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }

    public PedidoDTO(){}
}
