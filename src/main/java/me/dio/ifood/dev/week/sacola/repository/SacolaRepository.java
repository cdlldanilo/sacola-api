package me.dio.ifood.dev.week.sacola.repository;

import me.dio.ifood.dev.week.sacola.model.Sacola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SacolaRepository extends JpaRepository<Sacola, Long> {

}
