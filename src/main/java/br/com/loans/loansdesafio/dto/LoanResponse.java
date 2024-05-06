package br.com.loans.loansdesafio.dto;

import br.com.loans.loansdesafio.entities.enums.LoanType;

public record LoanResponse(
        LoanType Type,
        int interest_rate
) {
}
