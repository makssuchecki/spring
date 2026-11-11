package com.example.artworks.exception;

public class ArtworkNotFoundException extends RuntimeException {
    public ArtworkNotFoundException(String id) {
        super("Artwork with id '" + id + "' not found");
    }
}