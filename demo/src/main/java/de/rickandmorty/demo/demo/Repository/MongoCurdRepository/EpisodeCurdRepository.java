package de.rickandmorty.demo.demo.Repository.MongoCurdRepository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import de.rickandmorty.demo.demo.Entity.Episode;

@NoRepositoryBean
public interface EpisodeCurdRepository extends CrudRepository<Episode, Integer> {
    Episode findById(int id);
    
    List<Episode> findByNameContaining(String name);
}
