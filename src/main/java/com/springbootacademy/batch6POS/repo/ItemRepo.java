package com.springbootacademy.batch6POS.repo;

import com.springbootacademy.batch6POS.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer> {
    List<Item> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);

    Page<Item> findAllByActiveStateEquals(boolean activeState, Pageable of);

    long countAllByActiveStateEquals(boolean activeState);
}
