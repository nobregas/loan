package br.com.loans.loansdesafio.dto;

import br.com.loans.loansdesafio.entities.Customer;

public record CustomerRequestDto(
        Integer age,
        String cpf,
        String name,
        Double income,
        String location
) {
    public Customer toCustomer() {
        return new Customer(
                this.age,
                this.cpf,
                this.name,
                this.income,
                this.location
        );
    }

}
