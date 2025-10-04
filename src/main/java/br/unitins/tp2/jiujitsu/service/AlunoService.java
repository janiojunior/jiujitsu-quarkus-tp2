package br.unitins.tp2.jiujitsu.service;

import java.util.List;

import br.unitins.tp2.jiujitsu.dto.AlunoDTO;
import br.unitins.tp2.jiujitsu.dto.AlunoResponseDTO;


public interface AlunoService {

        // recursos basicos
        List<AlunoResponseDTO> getAll(int page, int pageSize);

        AlunoResponseDTO findById(Long id);
    
        AlunoResponseDTO create(AlunoDTO dto);
    
        AlunoResponseDTO update(Long id, AlunoDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<AlunoResponseDTO> findByNome(String nome, int page, int pageSize);
    
        long count();

        long countNome(String nome);
    
}