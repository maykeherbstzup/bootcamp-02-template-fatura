package zup.nossocartao.fatura.modules.CreditCard;

import zup.nossocartao.fatura.modules.Invoice.Invoice;
import zup.nossocartao.fatura.modules.Invoice.InvoiceRepository;
import zup.nossocartao.fatura.modules.Invoice.InvoiceStatus;
import zup.nossocartao.fatura.services.CreditCard.CreditCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/credit-card")
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    @Autowired
    InvoiceRepository invoiceRepository;

    @GetMapping("/{id}/limit")
    public ResponseEntity<?> getLimit(@PathVariable(value = "id") String id) {
        BigDecimal limit = this.creditCardService.getLimit(id);

        Invoice invoice = this.invoiceRepository.findByCardIdAndStatus(id, InvoiceStatus.OPEN);

        CreditCardLimitResponse creditCardLimitResponse =
                new CreditCardLimitResponse(limit, limit.subtract(invoice.getTotal()));

        return ResponseEntity.ok(creditCardLimitResponse);
    }
}
