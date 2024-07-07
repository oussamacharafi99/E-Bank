package com.bank.Repository;
import com.bank.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryTransaction extends JpaRepository<Transaction , Integer>{
    List<Transaction> findTransactionsByCompte_Id(Integer id);
}
