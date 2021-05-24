package com.finance.layer2;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TRANSACTION_TABLE database table.
 * 
 */
@Entity
@Table(name="TRANSACTION_TABLE")
@NamedQuery(name="TransactionTable.findAll", query="SELECT t FROM TransactionTable t")
public class TransactionTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANS_ID")
	private int transId;

	@Column(name="DUE_AMT")
	private Long dueAmt;
	
	@Column(name="INSTALLMENT")
	private Long installment;

	@Column(name="MONTH_NO")
	private int monthNo;

	//@Temporal(TemporalType.DATE)
	@Column(name="TRANS_DATE",columnDefinition = "DATE")
	private LocalDate transDate;

	//bi-directional many-to-one association to OrderTable
	//@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="ORD_ID")
	private OrderTable orderTable;

	public TransactionTable() {
	}

	public long getTransId() {
		return this.transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public Long getDueAmt() {
		return this.dueAmt;
	}

	public void setDueAmt(Long dueAmt) {
		this.dueAmt = dueAmt;
	}

	public Long getInstallment() {
		return this.installment;
	}

	public void setInstallment(Long installment) {
		this.installment = installment;
	}

	public int getMonthNo() {
		return this.monthNo;
	}

	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}

	public LocalDate getTransDate() {
		return this.transDate;
	}

	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}

	public OrderTable getOrderTable() {
		return this.orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}

}