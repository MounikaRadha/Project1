package com.RadhaMounika.backend.DTO;

import lombok.Data;

@Data
public class PaymentResponseDTO {
    //from frontend we get these details and we use these to verify the authenticity of the payment
    public String razorpayPaymentId;
    public String razorpayOrderId;
    public String razorpaySignature;
    public String emailAddress;
}
