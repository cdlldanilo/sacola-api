package me.dio.ifood.dev.week.sacola.repository;

import me.dio.ifood.dev.week.sacola.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
