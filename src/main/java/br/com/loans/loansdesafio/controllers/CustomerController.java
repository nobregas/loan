package br.com.loans.loansdesafio.controllers;

import br.com.loans.loansdesafio.dto.CustomerRequestDto;
import br.com.loans.loansdesafio.dto.CustomerResponse;
import br.com.loans.loansdesafio.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> getCustonerLoans(@RequestBody CustomerRequestDto customer) {
        CustomerResponse customerView = customerService.getCustomerLoans(customer);
        return ResponseEntity.ok(customerView);
    }
}
