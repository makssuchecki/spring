package com.example.artworks.repository;

import com.example.artworks.model.Artwork;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ArtworkRepository {
    private final Map<String, Artwork> db = new ConcurrentHashMap<>();

    public Collection<Artwork> findAll() { return db.values(); }
    public Optional<Artwork> findById(String id) { return Optional.ofNullable(db.get(id)); }
    public boolean exists(String id) {return db.containsKey(id); }
    public Artwork remove(String id) { return db.remove(id); }
    public Artwork save(Artwork artwork){
        if (artwork.getId() == null){
            artwork.setId(UUID.randomUUID().toString());
        }
        db.put(artwork.getId(), artwork);
        return artwork;
    }
}

