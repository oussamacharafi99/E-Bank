package com.bank.Repository;
import com.bank.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTransaction extends JpaRepository<Transaction , Integer>{
}
