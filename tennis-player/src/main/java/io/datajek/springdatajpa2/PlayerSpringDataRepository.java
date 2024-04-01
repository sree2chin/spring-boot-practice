package io.datajek.springdatajpa2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// with this single line all orm methods are available on the entity
public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer>{

    public List<Player> findByNationality(String nationality);

}