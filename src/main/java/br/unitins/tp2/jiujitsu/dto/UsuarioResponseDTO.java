package br.unitins.tp2.jiujitsu.dto;

import br.unitins.tp2.jiujitsu.model.Perfil;
import br.unitins.tp2.jiujitsu.model.Usuario;

public record UsuarioResponseDTO(Long id, String username, String senha, Perfil perfil) {

    public static UsuarioResponseDTO valueOf(Usuario usuario) {
        if (usuario == null)
            return null;
        return new UsuarioResponseDTO (
            usuario.getId(), 
            usuario.getUsername(), 
            usuario.getSenha(),
            usuario.getPerfil());
    }
    
}