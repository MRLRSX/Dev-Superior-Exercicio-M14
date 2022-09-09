package model.exceptions;

public class PaymentException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public PaymentException(String MSG) {
		super(MSG);
	}
}
