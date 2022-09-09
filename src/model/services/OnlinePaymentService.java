package model.services;

public interface OnlinePaymentService {
  
	public abstract double paymentFee(Double amount);
	public abstract double interest(Double amount, Integer months);
}
