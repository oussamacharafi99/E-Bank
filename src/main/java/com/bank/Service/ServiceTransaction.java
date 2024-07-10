package com.bank.Service;
import com.bank.Enums.TransactionType;
import com.bank.Model.Compte;
import com.bank.Model.Transaction;
import com.bank.Repository.RepositoryCompte;
import com.bank.Repository.RepositoryTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTransaction {
    @Autowired
    RepositoryTransaction repositoryTransaction;

    @Autowired
    RepositoryCompte repositoryCompte;

    public List<Transaction> GetTransactionByAccount(Integer id) {
        return repositoryTransaction.findTransactionsByCompte_Id(id);
    }

    public String CreateTransaction(Integer id , Transaction transaction) {
        if (transaction.getMontant() != null &&
                transaction.getMontant() > 0 &&
                transaction.getBeneficier().getId() != null
                && id != null ) {

            Compte compte = repositoryCompte.findById(id).orElseThrow();

            if (compte.getSolde() != null && compte.getSolde() > 0 && compte.getSolde() >= transaction.getMontant()) {
                if (transaction.getType_transaction() == TransactionType.credit) {
                    compte.setSolde(compte.getSolde() - transaction.getMontant());
                } else if (transaction.getType_transaction() == TransactionType.debit) {
                    compte.setSolde(compte.getSolde() + transaction.getMontant());
                } else {
                    return ("Type de transaction invalide");
                }
                repositoryCompte.save(compte);
                repositoryTransaction.save(transaction);
                return "Transaction Success";
            } else {
               return "Le solde du compte est insuffisant ou null";
            }
        } else {
            return "Le montant de la transaction doit etre Superieur à 0 et l'ID du bénéficiaire ne peut pas etre null";
        }
    }
}
