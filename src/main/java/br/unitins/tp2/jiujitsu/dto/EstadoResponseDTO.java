package br.unitins.tp2.jiujitsu.dto;

import br.unitins.tp2.jiujitsu.model.Estado;

public record EstadoResponseDTO (
    Long id,
    String nome,
    String sigla
) {
    public static EstadoResponseDTO valueOf(Estado estado) {
        return new EstadoResponseDTO(
            estado.getId(), 
            estado.getNome(), 
            estado.getSigla());
    }
    
}
