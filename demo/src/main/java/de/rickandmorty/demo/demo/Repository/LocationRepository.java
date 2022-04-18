package de.rickandmorty.demo.demo.Repository;

import org.springframework.stereotype.Repository;
import de.rickandmorty.demo.demo.Entity.Location;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LocationRepository {
    Location location1 = new Location(1,"Citadel of Ricks", "Space Station", "unknown");
    Location location2 = new Location(2,"Abadango", "Cluster", "unknown");
    Location location3 = new Location(3,"Earth (C-137)", "Planet", "Dimension C-137");


    ArrayList<Location> locations = new ArrayList<Location>();

    public LocationRepository() {
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
    }

    public Location findById(int id) {
        return locations.stream()
                .filter(loc -> loc.getId() == id)
                .findFirst().orElse(null);
    }

    public List<Location> findByName(String name) {
        return locations.stream().filter(location -> location.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();

    }

    public Collection<Location> getLocationByCharacterId(int characterId) {
        return locations.stream()
                .filter(location -> location.getResidents() == null
                        || Arrays.stream(location.getResidents()).anyMatch(character -> character.getId() == characterId))
                .collect(Collectors.toList());
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

}
