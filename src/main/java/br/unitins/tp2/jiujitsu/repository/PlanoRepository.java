package br.unitins.tp2.jiujitsu.repository;

import br.unitins.tp2.jiujitsu.model.Plano;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlanoRepository implements PanacheRepository<Plano> {

    @Override
    public PanacheQuery<Plano> findAll() {
        return find("SELECT a FROM Plano a ORDER BY a.nome ");
    }

    public PanacheQuery<Plano> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%");
    }

    public long countNome(String nome) {
        return count("UPPER(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%");
    }

}
