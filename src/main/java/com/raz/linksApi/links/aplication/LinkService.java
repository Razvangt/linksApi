package com.raz.linksApi.links.aplication;

import com.raz.linksApi.links.domain.Link;
import com.raz.linksApi.links.infrastructure.in.LinkInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkService implements LinkInputPort {
    private final LinkRepository db;
    @Autowired
    public LinkService(LinkRepository db){
        this.db = db;
    }
    @Override
    public LinkResponse createLink(Link newLink) {
        Link link = db.create(newLink);
        return LinkResponse.builder()
                .link(link)
                .Response("Created Successfully").build();
    }

    @Override
    public List<Link> getAll() {
        return db.searchALL();
    }

    @Override
    public LinkResponse getById(String id) {
        Optional<Link> link = db.searchById(UUID.fromString(id));
        return  LinkResponse.builder()
                .link(link.get())
                .Response(link.isPresent()? "found" : "error")
                .build();
    }

    @Override
    public LinkResponse delete(String id) {
        // should check id to be sure is secure
        Boolean deleted =  db.delete(UUID.fromString(id));

        return LinkResponse.builder()
                .Response(deleted? "successful" : "error")
                .build();
    }

    @Override
    public LinkResponse update(Link link) {
        Link linkUpdated =  db.update(link);
        return  LinkResponse.builder()
                .link(linkUpdated)
                .Response(linkUpdated != null? "found" : "error")
                .build();
    }
}
