package br.com.loans.loansdesafio.services;

import br.com.loans.loansdesafio.dto.CustomerRequestDto;
import br.com.loans.loansdesafio.dto.CustomerResponse;
import br.com.loans.loansdesafio.dto.LoanResponse;
import br.com.loans.loansdesafio.entities.Customer;
import br.com.loans.loansdesafio.entities.Loan;
import br.com.loans.loansdesafio.entities.enums.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public CustomerResponse getCustomerLoans(CustomerRequestDto customerDto) {
        Customer customer = customerDto.toCustomer();
        List<LoanResponse> loans = getLoans(customer);
        return new CustomerResponse(customer.name(), loans);
    }

    private List<LoanResponse> getLoans(Customer customer) {
        List<LoanResponse> loans = new ArrayList<>();

        double customer_income = customer.income();

        if (customer_income <= 3000) {
            Loan personalLoan = new Loan(LoanType.PERSONAL);
            if (!loans.contains(personalLoan)) {
                loans.add(personalLoan.toView());
            }
        }

        if (customer_income <= 3000) {
            Loan guaranteedLoan = new Loan(LoanType.GUARANTEED);
            if (!loans.contains(guaranteedLoan)) {
                loans.add(guaranteedLoan.toView());
            }
        }

        if (customer_income > 3000
                && customer_income <= 5000
                && customer.age() < 30
                && customer.location().equals("SP")) {

            Loan guaranteedLoan = new Loan(LoanType.GUARANTEED);
            if (!loans.contains(guaranteedLoan)) {
                loans.add(guaranteedLoan.toView());
            }
        }

        if (customer_income > 3000
                && customer_income <= 5000
                && customer.age() < 30
                && customer.location().equals("SP")) {

            Loan personalLoan = new Loan(LoanType.PERSONAL);
            if (!loans.contains(personalLoan)) {
                loans.add(personalLoan.toView());
            }
        }

        if (customer_income >= 5000) {
            Loan consigmentLoan = new Loan(LoanType.CONSIGNMENT);
            if (!loans.contains(consigmentLoan)) {
                loans.add(consigmentLoan.toView());
            }
        }

        return loans;
    }
}

