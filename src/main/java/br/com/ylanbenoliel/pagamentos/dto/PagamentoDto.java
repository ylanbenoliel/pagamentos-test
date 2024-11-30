package br.com.ylanbenoliel.pagamentos.dto;

import br.com.ylanbenoliel.pagamentos.model.Status;
import java.math.BigDecimal;
import java.util.Objects;

public class PagamentoDto {
    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long pedidoId;
    private Long formaDePagamentoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(String expiracao) {
        this.expiracao = expiracao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getFormaDePagamentoId() {
        return formaDePagamentoId;
    }

    public void setFormaDePagamentoId(Long formaDePagamentoId) {
        this.formaDePagamentoId = formaDePagamentoId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PagamentoDto that = (PagamentoDto) o;
        return Objects.equals(id, that.id) && Objects.equals(valor, that.valor) && Objects.equals(nome, that.nome) && Objects.equals(numero, that.numero) && Objects.equals(expiracao, that.expiracao) && Objects.equals(codigo, that.codigo) && status == that.status && Objects.equals(pedidoId, that.pedidoId) && Objects.equals(formaDePagamentoId, that.formaDePagamentoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, nome, numero, expiracao, codigo, status, pedidoId, formaDePagamentoId);
    }
}
