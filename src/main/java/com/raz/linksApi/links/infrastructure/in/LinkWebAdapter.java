package com.raz.linksApi.links.infrastructure.in;

import com.raz.linksApi.links.aplication.LinkDTO;
import com.raz.linksApi.links.aplication.LinkResponse;
import com.raz.linksApi.links.domain.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "api/link")
public class LinkWebAdapter {
    private final LinkInputPort linkInputPort;

    @Autowired
    public LinkWebAdapter(LinkInputPort linkInputPort){
        this.linkInputPort = linkInputPort;
    }
    @GetMapping
    public List<LinkDTO> getAll (){
      return linkInputPort.getAll();
    }
    @GetMapping("/{link_id}")
    public LinkResponse getById(@PathVariable String link_id){
        return linkInputPort.getById(link_id);
    }
    @GetMapping("/workspace/{space_id}")
    public List<LinkDTO> getLinksByWorkSpaceId(@PathVariable String space_id){
        return linkInputPort.getBydWorkSpaceId(space_id);
    }
    @PostMapping
    public LinkResponse create(@RequestParam(required = false) String space_id, @RequestBody Link newLink){
        return space_id != null ? linkInputPort.createLink(space_id,newLink) : linkInputPort.createLink(newLink);
    }
    @DeleteMapping("/{link_id}")
    public LinkResponse delete(@PathVariable String link_id){
        return linkInputPort.delete(link_id);}
    @PutMapping("/")
    public LinkResponse update(@RequestParam(required = false) String space_id,@RequestBody Link  link){
        return space_id != null ? linkInputPort.update(space_id, link) : linkInputPort.update( link);
    }
    
}
