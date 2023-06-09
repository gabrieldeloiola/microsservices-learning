package br.com.gpess.hrpayroll.services;

import br.com.gpess.hrpayroll.entities.Payment;
import br.com.gpess.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    @Value("${hr-worker.host}")
    private String workerHost;
    private RestTemplate restTemplate;
    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Payment getPayment(Long workerId, int days){
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", ""+workerId);
        Worker worker = restTemplate.getForObject(workerHost+"/workers/{id}",Worker.class,uriVariable);
        return new Payment(worker.getName(), worker.getDailyIncome(),days);
    }
}
