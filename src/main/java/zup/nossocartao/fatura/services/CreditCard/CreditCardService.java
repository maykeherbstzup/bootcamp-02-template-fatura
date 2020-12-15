package zup.nossocartao.fatura.services.CreditCard;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreditCardService {
    @Autowired
    CreditCardInterface creditCardInterface;

    public BigDecimal getLimit(String cardId) {
            try {
                CreditCardResponse creditCardResponse = this.creditCardInterface.getLimit(cardId);

                return creditCardResponse.getLimit();
            } catch (FeignException e) {
                if (!(e instanceof FeignException.NotFound)) {
                    throw e;
                }
            }

        return BigDecimal.ZERO;
    }
}
