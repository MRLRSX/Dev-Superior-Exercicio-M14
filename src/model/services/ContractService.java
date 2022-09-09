package model.services;


import model.Contract;
import model.Installment;

public class ContractService {
   
	private OnlinePaymentService payment;

	public ContractService(OnlinePaymentService payment) {
		this.payment = payment;
	}

	public OnlinePaymentService getPayment() {
		return payment;
	}

	public void setPayment(OnlinePaymentService payment) {
		this.payment = payment;
	}
	
	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for(int x = 1; x <= months; x++) {
			double updateQuota = basicQuota + payment.interest(basicQuota, x);
			double fullQuota = updateQuota + payment.paymentFee(updateQuota);
			contract.getInstallmentList().add(new Installment(contract.getLocalDate().plusMonths(x), fullQuota));
		}
		
	}
}
