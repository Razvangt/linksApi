package com.raz.linksApi.links.aplication;

import com.raz.linksApi.links.domain.Link;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class LinkDTO {
    private UUID id;
    private String name;
    private String url;
    private String spaceTitle;

    public LinkDTO fromLink(Link link){
        this.id = link.getId();
        this.name = link.getName();
        this.url = link.getUrl();
        if( link.getWorkspace() != null){
            this.spaceTitle = link.getWorkspace().getTitle();
        }
        return  this;
    }
}