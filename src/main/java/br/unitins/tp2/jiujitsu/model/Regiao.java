package br.unitins.tp2.jiujitsu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Regiao {
    CENTRO_OESTE(1l, "Centro-Oeste"), 
    NORTE(2l, "Norte"), 
    NORDESTE(3l, "Nordeste"), 
    SUDESTE(4l, "Suldeste"), 
    SUL(5l, "Sul");

    private final Long ID;
    private final String NOME;

    Regiao(Long id, String nome) {
        this.ID = id;
        this.NOME = nome;
    }

    public Long getId() {
        return ID;
    }

    public String getNome() {
        return NOME;
    }

     public static Regiao valueOf(Long id) {
        for (Regiao r : Regiao.values()) {
            if (r.getId() == id)
                return r;
        }
        return null;
     }

}
