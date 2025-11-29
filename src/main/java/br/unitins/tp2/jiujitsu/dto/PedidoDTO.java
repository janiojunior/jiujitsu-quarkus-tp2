package br.unitins.tp2.jiujitsu.dto;

import java.util.List;

public record PedidoDTO(
    Double total,
    List<ItemPedidoDTO> itensPedido
) { }