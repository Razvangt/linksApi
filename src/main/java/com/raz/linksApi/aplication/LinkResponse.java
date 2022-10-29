package com.raz.linksApi.aplication;

import com.raz.linksApi.domain.Link;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LinkResponse {
    private Link link;
    private String Response;
}
