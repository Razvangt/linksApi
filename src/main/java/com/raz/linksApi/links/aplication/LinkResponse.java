package com.raz.linksApi.links.aplication;

import com.raz.linksApi.links.domain.Link;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LinkResponse {
    private LinkDTO link;
    private String Response;
}
