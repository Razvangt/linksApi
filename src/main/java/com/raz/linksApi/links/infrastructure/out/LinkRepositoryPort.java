package com.raz.linksApi.links.infrastructure.out;

import com.raz.linksApi.links.domain.Link;
import com.raz.linksApi.links.aplication.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkRepositoryPort implements LinkRepository {
    private final LinkAdapterJPA db;

    @Autowired
    public LinkRepositoryPort ( LinkAdapterJPA db){
        this.db = db;
    }
    @Override
    public List<Link> searchALL() {
        return db.findAll();
    }
    @Override
    public Optional<Link> searchById(UUID id){
            return db.findById(id);
    }
    @Override
    public Link create(Link newLink) {
        return db.save(newLink);
    }
    @Override
    public Boolean delete(UUID id) {
       if (searchById(id).isEmpty()){
           return false;
       }
       db.deleteById(id);
       return true;
    }

    @Override
    public Link update(Link linkUpdated) {
        Optional<Link> result = searchById(linkUpdated.getId());
        if(result.isEmpty()){
            return null;
        }
        return db.save(linkUpdated);
    }

    @Override
    public List<Link> searchByWorkSpaceId(UUID id) {
        return db.findAllByWorkspaceId(id);
    }
}
