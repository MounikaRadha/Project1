package com.RadhaMounika.backend.service.payments;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
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

    @Value("${spring.razorpay.KEY_ID}")
    private  String KEY_ID;

    @Value("${spring.razorpay.KEY_SECRET}")
    private  String KEY_SECRET;
    public String createOrderURL() throws RazorpayException {

        RazorpayClient razorpayClient= new RazorpayClient(KEY_ID,KEY_SECRET);
        JSONObject orderRequest= new JSONObject();
        orderRequest.put("amount",10000);
        orderRequest.put("currency","INR");
        Order order=razorpayClient.orders.create(orderRequest);
        log.info("order is {}", order);
        return order.toString();
    }
}
