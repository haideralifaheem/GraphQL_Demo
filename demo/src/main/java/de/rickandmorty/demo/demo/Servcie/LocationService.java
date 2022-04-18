package de.rickandmorty.demo.demo.Servcie;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import de.rickandmorty.demo.demo.Entity.Location;
import de.rickandmorty.demo.demo.Repository.LocationRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@GraphQLApi
@Service
public class LocationService {

    private final LocationRepository locationRepo;

    public LocationService( LocationRepository locRepo) {
        this.locationRepo=locRepo;
    }

    @GraphQLQuery
    public Location LocationById(int id) {
        return locationRepo.findById(id);
    }

    @GraphQLQuery
    public List<Location> LocationByName(String name) {
        return locationRepo.findByName(name);
    }


    @GraphQLQuery
    public Collection<Location> Locations(int characterId) {
        return this.locationRepo.getLocationByCharacterId(characterId);
    }

    
}
