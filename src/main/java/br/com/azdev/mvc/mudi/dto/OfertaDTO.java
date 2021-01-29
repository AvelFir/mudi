package br.com.azdev.mvc.mudi.dto;

import br.com.azdev.mvc.mudi.model.Oferta;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OfertaDTO {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long pedidoId;
    @Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
    @NotNull
    private String valorProduto;
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    @NotNull
    private String dataDaEntrega;

    private String comentario;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(String valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(String dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario((this.comentario));
        oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, formatter));
        oferta.setValorProduto(new BigDecimal(this.valorProduto));
        return oferta;
    }
}
