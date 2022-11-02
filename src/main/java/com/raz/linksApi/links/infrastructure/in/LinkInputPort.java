package com.raz.linksApi.links.infrastructure.in;

import com.raz.linksApi.links.aplication.LinkDTO;
import com.raz.linksApi.links.aplication.LinkResponse;
import com.raz.linksApi.links.domain.Link;

import java.util.List;

public interface LinkInputPort {
     LinkResponse createLink(Link newLink);
     LinkResponse createLink(String space_id ,Link newLink);
     List<LinkDTO> getAll();
     LinkResponse getById(String id);
     LinkResponse delete(String id);
     LinkResponse update(Link updatedLink);

     LinkResponse update(String spaceId, Link link);
}
