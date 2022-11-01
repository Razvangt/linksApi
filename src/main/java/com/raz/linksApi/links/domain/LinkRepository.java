package com.raz.linksApi.links.domain;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.raz.linksApi.links.domain.Link;

public interface LinkRepository {
    List<Link> searchALL();

    Optional<Link> searchById(UUID id);

    Link create(Link newLink);

    Boolean delete(UUID id);

    Link update(Link linkUpdated);
}
