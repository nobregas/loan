package br.com.loans.loansdesafio.dto;



import java.util.List;

public record CustomerResponse(
        String customer,
        List<LoanResponse> loans
) {
}
