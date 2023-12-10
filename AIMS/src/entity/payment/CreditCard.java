package entity.payment;

import java.sql.Timestamp;

// Functional cohesion
/* Các thuộc tính như cardCode, owner, cvvCode, và 
dateExpired đều liên quan chặt chẽ đến mục đích chính của lớp */
public class CreditCard {
	private String cardCode;
	private String owner;
	private int cvvCode;
	private String dateExpired;

	public CreditCard(String cardCode, String owner, int cvvCode, String dateExpired) {
		super();
		this.cardCode = cardCode;
		this.owner = owner;
		this.cvvCode = cvvCode;
		this.dateExpired = dateExpired;
	}
}
