package zup.nossocartao.fatura.modules.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import zup.nossocartao.fatura.modules.Invoice.Invoice;
import zup.nossocartao.fatura.modules.Invoice.InvoiceRepository;
import zup.nossocartao.fatura.modules.Invoice.InvoiceStatus;
import zup.nossocartao.fatura.modules.Transaction.dto.TransactionEventResponse;

import java.time.LocalDate;
import java.time.temporal.TemporalUnit;

@Component
public class TransactionListener {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionEventResponse transactionEventResponse) {
        Transaction transaction = transactionEventResponse.toModel();

        Invoice currentInvoice = invoiceRepository.findByCardIdAndStatus(transaction.getCardId(), InvoiceStatus.OPEN);

        if (currentInvoice == null) {
            LocalDate current = LocalDate.now();
            LocalDate start = current.withDayOfMonth(1);
            LocalDate end = current.withDayOfMonth(current.lengthOfMonth());
            LocalDate dueDate = end.plusDays(10);

            currentInvoice = new Invoice(transaction.getCardId(), start, end, dueDate, InvoiceStatus.OPEN);

            invoiceRepository.save(currentInvoice);
        }

        transaction.setInvoice(currentInvoice);

        transactionRepository.save(transaction);
    }
}
