package br.com.loans.loansdesafio.entities;

import br.com.loans.loansdesafio.dto.LoanResponse;
import br.com.loans.loansdesafio.entities.enums.LoanType;

public class Loan {
    private LoanType type;
    private int interest_rate;

    public Loan(LoanType type) {
        this.type = type;

        switch (type) {
            case PERSONAL -> this.interest_rate = 4;
            case CONSIGNMENT -> this.interest_rate = 2;
            case GUARANTEED -> this.interest_rate = 3;
        }
    }

    public LoanResponse toView() {
        return new LoanResponse(type, interest_rate);
    }
}
