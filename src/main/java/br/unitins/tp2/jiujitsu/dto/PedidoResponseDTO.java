package br.unitins.tp2.jiujitsu.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp2.jiujitsu.model.Pedido;

public record PedidoResponseDTO(
        Long id,
        LocalDateTime data,
        Double total,
        UsuarioResponseDTO usuario,
        List<ItemPedidoResponseDTO> itensPedido) {

    public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getData(),
                pedido.getTotal(),
                UsuarioResponseDTO.valueOf(pedido.getUsuario()),
                pedido.getItensPedido().stream().map(ip -> ItemPedidoResponseDTO.valueOf(ip)).toList());
    }
}