package zup.nossocartao.fatura.modules.Transaction;

import org.hibernate.annotations.GenericGenerator;
import zup.nossocartao.fatura.modules.Invoice.Invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    private BigDecimal value;

    @NotNull
    private String cardId;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String transactionId;

    @NotNull
    private LocalDateTime effectiveOn;

    @NotNull
    private String city;

    @NotNull
    private String address;

    @NotNull
    @ManyToOne
    private Invoice invoice;

    @Deprecated
    public Transaction() {}

    public Transaction(@NotNull BigDecimal value, @NotNull String cardId, @NotNull String email,
                       @NotNull String name, @NotNull String transactionId, @NotNull LocalDateTime effectiveOn,
                       @NotNull String city, @NotNull String address) {
        this.value = value;
        this.cardId = cardId;
        this.email = email;
        this.name = name;
        this.transactionId = transactionId;
        this.effectiveOn = effectiveOn;
        this.city = city;
        this.address = address;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCardId() {
        return cardId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getTransactionId() {
        return transactionId;
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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
