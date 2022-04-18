package de.rickandmorty.demo.demo.Repository.MongoCurdRepository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import de.rickandmorty.demo.demo.Entity.Location;

@NoRepositoryBean
public interface LocationCurdRepository extends CrudRepository<Location, Integer> {
    Location findById(int id);
    
    List<Location> findByNameContaining(String name);
}
