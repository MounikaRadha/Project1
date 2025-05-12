package com.RadhaMounika.backend.controller;

import com.RadhaMounika.backend.DTO.PaymentResponseDTO;
import com.RadhaMounika.backend.service.EmailAddressService;
import com.RadhaMounika.backend.service.NewsService;
import com.RadhaMounika.backend.service.payments.RazorPayService;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Home {
    private final NewsService newsService;
    private final EmailAddressService emailAddressService;
    private final RazorPayService razorPayService;


    @GetMapping("/")
    public String home() {
        return "helllllo world";
    }

    @CrossOrigin(origins = "https://project1-iota-flame.vercel.app")
    @GetMapping("scrape")
    public String scrape() {
        //scrapes data using a python script and returns a string of news ,saves,shares via email
        return newsService.scrapeAndSaveNews();
    }

    /**
     * commenting out add email address as the service method will be called once payment finishes successfully
     * //    @GetMapping("addEmailAddress")
     * public String addEmailAddress(@RequestParam String emailAddress) {
     * //users email address will come here we add it to db if not exists and send email
     * return emailAddressService.addEmailAddress(emailAddress);
     * }
     **/

    @GetMapping("createOrder")
    @CrossOrigin(origins = "https://project1-iota-flame.vercel.app")
    public String createOrder() throws RazorpayException {
        //generate checkout url using razor pay orders api
        return razorPayService.createOrderURL();
    }

    @CrossOrigin(origins = "https://project1-iota-flame.vercel.app")
    @PostMapping("handlePayment")
    public String handlePayment(@RequestBody PaymentResponseDTO paymentResponseDTO) throws RazorpayException {
        //takes the response after user pays
        //verifies the signature
        //will add user email to db and share news
        return razorPayService.handlePayment(paymentResponseDTO);
    }

}
