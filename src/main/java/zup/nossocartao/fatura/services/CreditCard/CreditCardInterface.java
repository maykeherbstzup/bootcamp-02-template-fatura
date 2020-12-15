package zup.nossocartao.fatura.services.CreditCard;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "CreditCard", url = "${credit_card.url}")
public interface CreditCardInterface {
    @GetMapping(path = "/api/cartoes/{id}")
    CreditCardResponse getLimit(@PathVariable(name = "id") String id);
}