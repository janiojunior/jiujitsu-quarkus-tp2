package br.unitins.tp2.jiujitsu.dto;

import br.unitins.tp2.jiujitsu.model.Telefone;

public record TelefoneResponseDTO(
        String codigoArea,
        String numero) 
{
    public static TelefoneResponseDTO valueOf(Telefone telefone) {
        return new TelefoneResponseDTO(
                telefone.getCodigoArea(),
                telefone.getNumero());
    }
}