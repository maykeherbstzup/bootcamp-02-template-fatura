package zup.nossocartao.fatura.modules.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findTop10ByCardId(String id);
}
