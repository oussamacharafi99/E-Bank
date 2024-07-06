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

    public List<Transaction> getTransaction() {
         return  repositoryTransaction.findAll();
    }

    public Transaction GetTransactionByAccount(int id) {
        return repositoryTransaction.findById(id).orElseThrow();
    }

    public String CreateTransaction(Transaction transaction) {
        if (transaction.getMontant() != null &&
                transaction.getMontant() > 0 &&
                transaction.getBeneficier() != null &&
                transaction.getBeneficier().getId() != null) {

            Compte compte = repositoryCompte.findById(transaction.getCompte().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Le compte spécifié est introuvable"));

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
               return "Le solde du compte est insuffisant ou nul";
            }
        } else {
            return "Le montant de la transaction doit être supérieur à 0 et l'ID du bénéficiaire ne peut pas être nul";
        }
    }
}
