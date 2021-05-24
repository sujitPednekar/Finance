package com.finance.layer3;

import java.util.Set;

import org.springframework.stereotype.Repository;
import com.finance.layer2.TransactionTable;

@Repository
public interface TransactionRepository {
	void addTransaction(TransactionTable tRef);   //C - add/create
	TransactionTable findTransaction(int transno);     //R - find/reading
	Set<TransactionTable> findAllTransactions();     //R - find all/reading all
	void modifyTransaction(TransactionTable tRef); //U - modify/update
	void removeTransaction(int transno); //D - remove/delete
	Set<TransactionTable> findTransactionsByOrder(int ordId);
}
