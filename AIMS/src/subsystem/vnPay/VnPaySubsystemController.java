package subsystem.vnPay;

import common.exception.*;
import entity.payment.PaymentTransaction;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
<<<<<<< HEAD
import utils.VnPayConfig;
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669

public class VnPaySubsystemController {

    private static final String PAY_COMMAND = "pay";
    private static final String VERSION = "2.1.0";

//  private static VnPayService vnPayService = new VnPayService();


    /**
     * @param amount
     * @param contents
     * @return PaymentTransaction
     */
    public PaymentTransaction refund(int amount, String contents) {
        return null;
    }

<<<<<<< HEAD
=======

//  /**
//   * @param data
//   * @return String
//   */
//  private String generateData(Map<String, Object> data) {
//    return ((MyMap) data).toJSON();
//  }

//  public static String convertToQueryString(Map<String, Object> paramMap) throws UnsupportedEncodingException {
//    StringBuilder queryString = new StringBuilder();
//
//    for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
//      String key = entry.getKey();
//      Object value = entry.getValue();
//
//      // Kiểm tra nếu giá trị là null
//      if (value != null) {
//        // Chuyển đổi giá trị thành chuỗi
//        String encodedValue = URLEncoder.encode(value.toString(), "UTF-8");
//
//        // Thêm vào chuỗi tham số truy vấn
//        if (queryString.length() > 0) {
//          queryString.append("&");
//        }
//        queryString.append(key).append("=").append(encodedValue);
//      }
//    }
//
//    return queryString.toString();
//  }

>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    /**
     * @param money
     * @param contents
     * @return PaymentTransaction
     */
    public String generatePayOrderUrl(int money, String contents) throws IOException {

        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        long amount = money * 100L * 1000;


<<<<<<< HEAD
        String vnp_TxnRef = VnPayConfig.getRandomNumber(8);
        String vnp_IpAddr = VnPayConfig.getIpAddress();

        String vnp_TmnCode = VnPayConfig.vnp_TmnCode;
=======
        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_IpAddr = Config.getIpAddress();

        String vnp_TmnCode = Config.vnp_TmnCode;
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");

        vnp_Params.put("vnp_BankCode", "");

        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", contents);
        vnp_Params.put("vnp_OrderType", orderType);


        vnp_Params.put("vnp_Locale", "vn");

<<<<<<< HEAD
        vnp_Params.put("vnp_ReturnUrl", VnPayConfig.vnp_ReturnUrl);
=======
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
<<<<<<< HEAD
        String vnp_SecureHash = VnPayConfig.hmacSHA512(VnPayConfig.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        return VnPayConfig.vnp_PayUrl + "?" + queryUrl;
=======
        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        return Config.vnp_PayUrl + "?" + queryUrl;
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    }


    /**
     * @param response
     * @return PaymentTransaction
     */
    public PaymentTransaction makePaymentTransaction(Map<String, String> response) throws TransactionNotDoneException, TransactionFailedException, TransactionReverseException, UnrecognizedException, ParseException {
        if (response == null) {
            return null;
        }

        // Create Payment transaction
        String errorCode = response.get("vnp_TransactionStatus");
        String transactionId = response.get("vnp_TransactionNo");
        String transactionContent = response.get("vnp_OrderInfo");
        int amount = Integer.parseInt((String) response.get("vnp_Amount")) / 100;
        String createdAt = response.get("vnp_PayDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

            Date date = dateFormat.parse(createdAt);
            PaymentTransaction trans = new
                PaymentTransaction(errorCode, transactionId, transactionContent, amount, date);
            switch (trans.getErrorCode()) {
                case "00":
                    break;
                case "01":
                    throw new TransactionNotDoneException();
                case "02":
                    throw new TransactionFailedException();
                case "04":
                    throw new TransactionReverseException();
                case "05":
                    throw new ProcessingException();
                case "09":
                    throw new RejectedTransactionException();
                case "06":
                    throw new SendToBankException();
                case "07":
                    throw new AnonymousTransactionException();
                default:
                    throw new UnrecognizedException();
            }

            return trans;



    }

}
