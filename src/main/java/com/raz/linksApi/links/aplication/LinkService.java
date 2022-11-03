package com.raz.linksApi.links.aplication;

import com.raz.linksApi.links.domain.Link;
import com.raz.linksApi.links.infrastructure.in.LinkInputPort;
import com.raz.linksApi.workspaces.aplication.WorkSpaceRepository;
import com.raz.linksApi.workspaces.domain.WorkSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
 
@Service
public class LinkService implements LinkInputPort {
    private final LinkRepository db;
    private final WorkSpaceRepository spaceDB;
    @Autowired
    public LinkService(LinkRepository db, WorkSpaceRepository spaceDB){
        this.db = db;
        this.spaceDB = spaceDB;
    }

    @Override
    public LinkResponse createLink(Link newLink) {
        Link link = db.create(newLink);
        return LinkResponse.builder()
                .link(LinkDTO.builder().build().fromLink(link))
                .Response("Created Successfully")
                .build();

    }

    @Override
    public LinkResponse createLink(String space_id, Link newLink) {
        Link link = newLink;

        Optional<WorkSpace> space = spaceDB.findById(UUID.fromString(space_id));
        if (space.isPresent()){
            link.setWorkspace(space.get());
        }
        link = db.create(link);
        return LinkResponse.builder()
                .link(LinkDTO.builder().build().fromLink(link))
                .Response("Created Successfully")
                .build();
    }

    @Override
    public List<LinkDTO> getAll() {
        return db.searchALL().stream().map(link -> LinkDTO.builder().build().fromLink(link)).collect(Collectors.toList());
    }

    @Override
    public LinkResponse getById(String id) {
        Optional<Link> link = db.searchById(UUID.fromString(id));
        if (link.isPresent()){
            return  LinkResponse.builder()
                                .link(LinkDTO.builder().build().fromLink(link.get()))
                                .Response("found")
                                .build();
        }else {
             return LinkResponse.builder()
                                .Response("Error")
                                .build();
        }
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
        .link(LinkDTO.builder().build().fromLink(linkUpdated))
        .Response(linkUpdated != null? "found" : "error")
        .build();
    }

    @Override
    public LinkResponse update(String spaceId, Link link) {
        Link linkUpdated =  link;

        Optional<WorkSpace> space = spaceDB.findById(UUID.fromString(spaceId));
        if (space.isPresent()){
            linkUpdated.setWorkspace(space.get());
        }
        linkUpdated = db.update(linkUpdated);
        return  LinkResponse.builder()
                 .link( LinkDTO.builder().build().fromLink(linkUpdated))
                 .Response("Done")
                 .build();
    }

    @Override
    public List<LinkDTO> getBydWorkSpaceId(String spaceId) {
        return db.searchByWorkSpaceId(UUID.fromString(spaceId)).stream().map(link -> LinkDTO.builder().build().fromLink(link)).collect(Collectors.toList());
    }
}
