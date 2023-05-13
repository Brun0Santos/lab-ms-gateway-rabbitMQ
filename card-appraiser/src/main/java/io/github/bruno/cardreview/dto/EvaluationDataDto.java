package io.github.bruno.cardreview.dto;

public class EvaluationDataDto {
    private String cpf;
    private Integer income;

    public EvaluationDataDto() {
    }

    public EvaluationDataDto(String cpf, Integer income) {
        this.cpf = cpf;
        this.income = income;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getIncome() {
        return income;
    }
}
