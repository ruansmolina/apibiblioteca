package br.com.runa.api_biblioteca.repositorys;

import br.com.runa.api_biblioteca.entitys.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
