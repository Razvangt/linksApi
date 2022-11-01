package com.raz.linksApi.links.infrastructure;

import com.raz.linksApi.links.aplication.LinkResponse;
import com.raz.linksApi.links.domain.Link;

import java.util.List;

public interface LinkInputPort {
     LinkResponse createLink(Link newLink);
     List<Link> getAll();

     LinkResponse getById(String id);
     LinkResponse delete(String id);
     LinkResponse update(Link updatedLink);
}
