package com.raz.linksApi.workspaces.aplication;

import com.raz.linksApi.links.aplication.LinkDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class WorkSpaceDto {
    private UUID spaceId;
    private String title;
    private List<LinkDTO> links;
}