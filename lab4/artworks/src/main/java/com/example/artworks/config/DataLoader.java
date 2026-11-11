package com.example.artworks.config;

import com.example.artworks.model.Artwork;
import com.example.artworks.repository.ArtworkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataLoader implements CommandLineRunner {
    private final ArtworkRepository repository;

    public DataLoader(ArtworkRepository repository){
        this.repository = repository;
    }
    @Override
    public void run(String... args){
        repository.save(new Artwork("1a8aef52-019c-45db-8588-06ee495d907e", "Girl with a Pearl Earring", "painting", 1665, "Johannes Vermeer", "baroque", "oil on canvas"));
        repository.save(new Artwork("a2053c1d-f356-4640-9747-637f4844c734", "The Thinker", "sculpture", 1904, "Auguste Rodin", "modernism", "bronze"));
        repository.save(new Artwork("994a461d-e60b-487e-b4e6-6537e5631525", "Nighthawks", "painting", 1942, "Edward Hopper", "realism", "oil on canvas"));
        repository.save(new Artwork("618225a5-7fe3-492a-8c7b-26391d170258", "Lovers", "painting", 1928, "Rene Magritte", "surrealism", "oil on canvas"));
        repository.save(new Artwork("92799fbe-136a-46bc-bb0a-0c57b4bda0c6", "Unique Forms of Continuity in Space", "sculpture", 1913, "Umberto Boccioni", "futurism", "plaster"));
    }
}
