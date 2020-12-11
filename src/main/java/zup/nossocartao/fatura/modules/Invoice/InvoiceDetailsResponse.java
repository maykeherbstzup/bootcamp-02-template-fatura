package zup.nossocartao.fatura.modules.Invoice;

import zup.nossocartao.fatura.modules.Transaction.Transaction;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class InvoiceDetailsResponse {
    private String cardId;
    private LocalDate openingDate;
    private LocalDate closingDate;
    private LocalDate dueDate;
    private InvoiceStatus status;
    private Set<TransactionDetailsResponse> transactions;

    public InvoiceDetailsResponse(Invoice invoice) {
        this.cardId = invoice.getCardId();
        this.openingDate = invoice.getOpeningDate();
        this.closingDate = invoice.getClosingDate();
        this.dueDate = invoice.getDueDate();
        this.status = invoice.getStatus();
        this.transactions = invoice.getTransactions()
                .stream()
                .map((Transaction transaction) -> new TransactionDetailsResponse(transaction))
                .collect(Collectors.toSet());
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

    public Set<TransactionDetailsResponse> getTransactions() {
        return transactions;
    }
}
