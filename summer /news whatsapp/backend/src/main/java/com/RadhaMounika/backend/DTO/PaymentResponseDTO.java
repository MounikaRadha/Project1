package com.RadhaMounika.backend.DTO;

import lombok.Data;

@Data
public class PaymentResponseDTO {
    public String razorpayPaymentId;
    public String razorpayOrderId;
    public String razorpaySignature;
    public String emailAddress;
}
