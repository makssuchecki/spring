    package com.example.artworks.web;

    import com.example.artworks.exception.ArtworkNotFoundException;
    import com.example.artworks.model.Artwork;
    import com.example.artworks.repository.ArtworkRepository;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

    import java.net.URI;
    import java.util.Collection;

    @RestController
    public class ArtworkController {

        private final ArtworkRepository repository;

        public ArtworkController(ArtworkRepository repository){
            this.repository = repository;
        }

        @GetMapping("/")
        public String hello() {
            return "Hello World!";
        }

        @GetMapping("/art")
        public Collection<Artwork> get(){
            return repository.findAll();
        }

        @GetMapping("/art/{id}")
        public Artwork getById(@PathVariable String id){
            return repository.findById(id).orElseThrow(() -> new ArtworkNotFoundException(id));
        }

        @PostMapping("/art")
        public ResponseEntity<Artwork> create(@RequestBody Artwork artwork){
            artwork.setId(null);
            Artwork saved = repository.save(artwork);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(saved.getId())
                    .toUri();
            return ResponseEntity.created(location).body(saved);
        }

        @DeleteMapping("/art/{id}")
        public ResponseEntity<Void> delete(@PathVariable String id){
            if (repository.remove(id) == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/art/{id}")
        public ResponseEntity<Artwork> update(@PathVariable String id, @RequestBody Artwork artwork){
            if (!repository.exists(id)){
                return ResponseEntity.notFound().build();
            }
            artwork.setId(id);
            return ResponseEntity.ok(repository.save(artwork));
        }
    }
