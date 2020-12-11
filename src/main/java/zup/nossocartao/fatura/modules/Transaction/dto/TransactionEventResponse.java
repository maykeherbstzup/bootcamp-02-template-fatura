package zup.nossocartao.fatura.modules.Transaction.dto;

import zup.nossocartao.fatura.modules.Transaction.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionEventResponse {
    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private Store estabelecimento;
    private Card cartao;

    public void setId(String id) {
        this.id = id;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public void setEstabelecimento(Store estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setCartao(Card cartao) {
        this.cartao = cartao;
    }

    public Transaction toModel() {
        return new Transaction(
                this.valor,
                this.cartao.getId(),
                this.cartao.getEmail(),
                this.estabelecimento.getNome(),
                this.id,
                this.efetivadaEm,
                this.estabelecimento.getCidade(),
                this.estabelecimento.getEndereco()
        );
    }
}
