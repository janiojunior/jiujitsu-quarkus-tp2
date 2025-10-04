package br.unitins.tp2.jiujitsu.service;

import java.util.List;

import br.unitins.tp2.jiujitsu.dto.MunicipioDTO;
import br.unitins.tp2.jiujitsu.dto.MunicipioResponseDTO;


public interface MunicipioService {

        // recursos basicos
        List<MunicipioResponseDTO> getAll(int page, int pageSize);

        MunicipioResponseDTO findById(Long id);
    
        MunicipioResponseDTO create(MunicipioDTO dto);
    
        MunicipioResponseDTO update(Long id, MunicipioDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<MunicipioResponseDTO> findByNome(String nome, int page, int pageSize);
    
        long count();
    
}