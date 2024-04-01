package br.ufrn.lojamicroservico.repository;

import br.ufrn.lojamicroservico.domain.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LojaRepository extends JpaRepository<Loja, Long> {
    List<Loja> findByName(String name);
}
