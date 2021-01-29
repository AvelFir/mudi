package br.com.azdev.mvc.mudi.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal valorProduto;
    private LocalDate dataDaEntrega;
    private String comentario;


    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public LocalDate getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(LocalDate dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
