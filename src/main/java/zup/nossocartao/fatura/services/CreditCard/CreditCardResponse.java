package zup.nossocartao.fatura.services.CreditCard;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CreditCardResponse {
    @JsonProperty("id")
    private String cardNumber;

    private BigDecimal limit;

    public CreditCardResponse() {}

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
