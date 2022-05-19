package de.rickandmorty.demo.demo.Repository.MongoCurdRepository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import de.rickandmorty.demo.demo.Entity.Location;

@Repository
public interface LocationCurdRepository extends CrudRepository<Location, Integer> {
    Location findById(int id);
    
    List<Location> findByNameContaining(String name);
}
