package com.finance;



import java.time.LocalDate;

import java.util.HashSet;

import java.util.Set;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.CardTable;
import com.finance.layer2.OrderTable;
import com.finance.layer2.ProductTable;
import com.finance.layer2.TransactionTable;
import com.finance.layer3.CardTableRepository;
import com.finance.layer3.OrderRepository;
import com.finance.layer3.ProductRepository;
import com.finance.layer3.TransactionRepository;

@ContextConfiguration
@SpringBootTest
class FinanceProjectApplicationTests {
	@Autowired
	TransactionRepository tranRepo;
	
	@Autowired
	OrderRepository ordRepo;
	
	@Autowired
	CardTableRepository crdRepo;
	
	@Autowired
	ProductRepository prdRepo;
	
	@Test
	void testCase1() {//find single transaction
		System.out.println("........");

		 TransactionTable tt=new TransactionTable();
		 tt=tranRepo.findTransaction(12);
		 System.out.println("transaction id:"+tt.getTransId());
		 System.out.println("due amt:"+tt.getDueAmt()); 
		 System.out.println("installment:"+tt.getInstallment());
		 System.out.println("order id:"+tt.getOrderTable().getOrdId());
		 System.out.println("month no:"+tt.getMonthNo());
		 System.out.println("Date of transaction:"+tt.getTransDate());

		 
		}
	
	@Test
	void testCase2() {//find all transactions
		System.out.println("..........................");
		Set<TransactionTable> tranSet = new HashSet<>();
		  tranSet= tranRepo.findAllTransactions();
		 for(TransactionTable t:tranSet) {
			 System.out.println("trans id:"+t.getTransId()); 
			 System.out.println("due amt:"+t.getDueAmt()); 
			 System.out.println("order id:"+t.getOrderTable().getOrdId());
			 System.out.println("installment:"+t.getInstallment());
			 System.out.println("month no:"+t.getMonthNo());
			 System.out.println("Date of transaction:"+t.getTransDate());
			 System.out.println("..........................");
		 }
		 
		}
	
	@Test
	void testCase3() {// modify transaction
		System.out.println("..........................");
		TransactionTable tt3=new TransactionTable();
		tt3=tranRepo.findTransaction(49);
		Long l=372L;
		tt3.setDueAmt(l);
		tranRepo.modifyTransaction(tt3);
		}
	
	@Test
	void testCase4() {//add transaction
		System.out.println("..........................");
		TransactionTable tt4=new TransactionTable();
		OrderTable o= new OrderTable();
		o=ordRepo.findOrder(2);
		Long l=(long) 50000;
		Long ll=(long) 50000;
		tt4.setDueAmt(l);
		tt4.setInstallment(ll);
		tt4.setMonthNo(2);
		tt4.setTransDate(LocalDate.of(2021, 05,23 ));
		tt4.setOrderTable(o);
		
		tranRepo.addTransaction(tt4);
		
		}
	
	@Test
	void testCase5() {// delete transaction
		System.out.println("..........................");
		tranRepo.removeTransaction(50);
		
		}
	
	
	@Test
	void testCase6() {// add order
		System.out.println("..........................");
		OrderTable o1=new OrderTable();
		CardTable  c1=new CardTable();
		ProductTable p1=new ProductTable();
		p1=prdRepo.findProduct(1102l);
		
		c1=crdRepo.findCard(852014763l);
		o1.setDateOrder(LocalDate.of(2021, 05,23 ));
		o1.setEmiMonths(3);
		o1.setQuantity(1);
		o1.setRemainingAmount(33322l);
		o1.setEmiPerMonth(2000L);
		o1.setTotalCost(4000L);
		o1.setCardTable(c1);
		o1.setProductTable(p1);
		
		ordRepo.addOrder(o1);
		
		}
	@Test
	void testCase7() {// add product
		System.out.println("..........................");
		ProductTable p1=new ProductTable();
		p1.setProductName("xxx");
		prdRepo.addProduct(p1);
		
		}
	@Test
	void testCase8() {// delete product
		System.out.println("..........................");
		
		prdRepo.removeProduct(61l);
		
		}
	
	@Test
	void testCase9() {// find Transactions By Order
		System.out.println("..........................");
		Set<TransactionTable> tranSet2 = new HashSet<>();
		tranSet2=tranRepo.findTransactionsByOrder(1);
		for(TransactionTable tt1:tranSet2) {
			 System.out.println("trans id:"+tt1.getTransId()); 
			 System.out.println("due amt:"+tt1.getDueAmt()); 
			 System.out.println("order id:"+tt1.getOrderTable().getOrdId());
			 System.out.println("installment:"+tt1.getInstallment());
			 System.out.println("month no:"+tt1.getMonthNo());
			 System.out.println("Date of transaction:"+tt1.getTransDate());
			 System.out.println("..........................");
		 }
		
		
		}
		
	
}


	


