package zup.nossocartao.fatura.modules.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    InvoiceRepository invoiceRepository;

    @GetMapping("/{creditCardId}")
    public ResponseEntity<?> getCurrentBill(@PathVariable(value = "creditCardId") String creditCardId) {
        Invoice invoice = invoiceRepository.findByCardIdAndStatus(creditCardId, InvoiceStatus.OPEN);

        InvoiceDetailsResponse invoiceDetailsResponse = new InvoiceDetailsResponse(invoice);

        return ResponseEntity.ok(invoiceDetailsResponse);
    }
}
