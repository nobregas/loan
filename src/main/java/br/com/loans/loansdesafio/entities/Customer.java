package br.com.loans.loansdesafio.entities;

public record Customer(
        Integer age,
        String cpf,
        String name,
        Double income,
        String location
) {
}
