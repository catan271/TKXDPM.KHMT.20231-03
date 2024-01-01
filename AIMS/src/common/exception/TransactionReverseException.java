package common.exception;

<<<<<<< HEAD
;

=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
public class TransactionReverseException extends PaymentException {

    public TransactionReverseException() {
        super("ERROR: Giao dịch đảo (Khách hàng đã bị trừ tiền tại Ngân hàng nhưng GD chưa thành công ở VNPAY)!");
    }

}
