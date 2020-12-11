package zup.nossocartao.fatura.modules.Invoice;

import zup.nossocartao.fatura.modules.Transaction.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDetailsResponse {
    private BigDecimal value;
    private String name;
    private LocalDateTime effectiveOn;
    private String city;
    private String address;

    public TransactionDetailsResponse(Transaction transaction) {
        this.value = transaction.getValue();
        this.effectiveOn = transaction.getEffectiveOn();
        this.name = transaction.getName();
        this.city = transaction.getCity();
        this.address = transaction.getAddress();
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getEffectiveOn() {
        return effectiveOn;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
