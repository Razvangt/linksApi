package com.raz.linksApi.infrastructure.adapter;

import com.raz.linksApi.domain.Link;
import com.raz.linksApi.domain.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkRepositoryAdapter implements LinkRepository {
    @Autowired
    LinkAdapterJPA db;
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
}
