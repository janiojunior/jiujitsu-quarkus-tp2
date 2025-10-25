package br.unitins.tp2.jiujitsu.dto;

public record PlanoDTO(
    String nome,
    Integer maxAlunos,
    Integer maxProfessores,
    Double precoMensal,
    Double descontoAnual
) { }