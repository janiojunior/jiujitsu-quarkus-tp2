package br.unitins.tp2.jiujitsu.dto;

public record ItemPedidoDTO(
    Integer quantidade,
    Double preco,
    Long idPlano
) { }