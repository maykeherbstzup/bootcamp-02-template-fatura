package zup.nossocartao.fatura.modules.CreditCard;

import java.math.BigDecimal;

public class CreditCardLimitResponse {
    private BigDecimal totalLimit;
    private BigDecimal availableLimit;

    public CreditCardLimitResponse(BigDecimal totalLimit, BigDecimal availableLimit) {
        this.totalLimit = totalLimit;
        this.availableLimit = availableLimit;
    }

    public BigDecimal getAvailableLimit() {
        return availableLimit;
    }

    public BigDecimal getTotalLimit() {
        return totalLimit;
    }
}
