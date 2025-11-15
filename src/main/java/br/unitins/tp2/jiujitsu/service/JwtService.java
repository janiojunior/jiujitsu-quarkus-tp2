package br.unitins.tp2.jiujitsu.service;

import br.unitins.tp2.jiujitsu.dto.UsuarioResponseDTO;

public interface JwtService {
    public String generateJwt(UsuarioResponseDTO dto);
}
