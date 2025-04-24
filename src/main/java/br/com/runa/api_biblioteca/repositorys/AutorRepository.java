package br.com.runa.api_biblioteca.repositorys;

import br.com.runa.api_biblioteca.entitys.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Integer> {
}
