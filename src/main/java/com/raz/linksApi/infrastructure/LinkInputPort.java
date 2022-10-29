package com.raz.linksApi.infrastructure;

import com.raz.linksApi.aplication.LinkResponse;
import com.raz.linksApi.domain.Link;

import java.util.List;

public interface LinkInputPort {
    public LinkResponse createLink(Link newLink);
    public List<Link> getAll();

    public LinkResponse getById(String id);
    public LinkResponse delete(String id);
    public LinkResponse update(Link updatedLink);
}
