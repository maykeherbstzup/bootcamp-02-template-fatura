package zup.nossocartao.fatura.modules.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    public Invoice findByCardIdAndStatus(String CardId, InvoiceStatus status);
}
