package com.RadhaMounika.backend.service.payments;

import com.RadhaMounika.backend.DTO.PaymentResponseDTO;
import com.RadhaMounika.backend.service.EmailAddressService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RazorPayService {
    private final EmailAddressService emailAddressService;

    @Value("${spring.razorpay.KEY_ID}")
    private String KEY_ID;

    @Value("${spring.razorpay.KEY_SECRET}")
    private String KEY_SECRET;

    @Value("${spring.razorpay.amount}")
    private String amount;

    public String createOrderURL() throws RazorpayException {
        log.info("order url generation request received ...");
        RazorpayClient razorpayClient = new RazorpayClient(System.getenv("KEY_ID"), System.getenv("KEY_SECRET"));
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");
        Order order = razorpayClient.orders.create(orderRequest);
        log.info("order is {}", order);
        return order.toString();
    }

    public String handlePayment(PaymentResponseDTO paymentResponseDTO) throws RazorpayException {
        log.info("payment response dto is {}", paymentResponseDTO);
        if (isPaymentValid(paymentResponseDTO)) {
            log.info("payment is valid");
            return handleSuccessfulPayment(paymentResponseDTO);
        }
        return handleCheatingPayment();

    }

    private String handleCheatingPayment() {
        return "we checked the signature and it shows the payment has been tampered";
    }

    private String handleSuccessfulPayment(PaymentResponseDTO paymentResponseDTO) {
        return emailAddressService.addEmailAddress(paymentResponseDTO.getEmailAddress());

    }

    public boolean isPaymentValid(PaymentResponseDTO paymentResponseDTO) throws RazorpayException {
        //will take the dto generate our signature and verify the authenticity

        RazorpayClient razorpay = new RazorpayClient(System.getenv("KEY_ID"), System.getenv("KEY_SECRET"));


        String secret = System.getenv("KEY_SECRET");


        JSONObject options = new JSONObject();
        options.put("razorpay_order_id", paymentResponseDTO.getRazorpayOrderId());
        options.put("razorpay_payment_id", paymentResponseDTO.getRazorpayPaymentId());
        options.put("razorpay_signature", paymentResponseDTO.getRazorpaySignature());


        boolean status = Utils.verifyPaymentSignature(options, secret);
        log.info("payment authenticity status is {}", status);
        return status;
    }
}
