package zup.nossocartao.fatura.modules.Invoice;

import org.hibernate.annotations.GenericGenerator;
import zup.nossocartao.fatura.modules.Transaction.Transaction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    private String cardId;

    @NotNull
    private LocalDate openingDate;

    @NotNull
    private LocalDate closingDate;

    @NotNull
    private LocalDate dueDate;

    @NotNull
    private InvoiceStatus status;

    @OneToMany(mappedBy = "invoice")
    private Set<Transaction> transactions;

    @Deprecated
    public Invoice() {}

    public Invoice(String cardId, LocalDate openingDate, LocalDate closingDate, LocalDate dueDate,
                   InvoiceStatus status) {

        this.cardId = cardId;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public BigDecimal getTotal() {
        return this.transactions
                .stream()
                .map(transaction -> transaction.getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getCardId() {
        return cardId;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
