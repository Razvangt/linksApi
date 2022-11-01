package com.raz.linksApi.links.infrastructure.in;

import com.raz.linksApi.links.aplication.LinkResponse;
import com.raz.linksApi.links.domain.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "link")
public class LinkWebAdapter {
    private final LinkInputPort linkInputPort;

    @Autowired
    public LinkWebAdapter(LinkInputPort linkInputPort){
        this.linkInputPort = linkInputPort;
    }

    @GetMapping
    public List<Link> getAll (){
      return linkInputPort.getAll();
    }
    @GetMapping("/")
    public LinkResponse getById(@RequestParam String id){
        return linkInputPort.getById(id);
    }
    @PostMapping
    public LinkResponse create(@RequestBody Link  newLink){
        return linkInputPort.createLink(newLink);
    }
    @DeleteMapping("/")
    public LinkResponse delete(@RequestParam String id){
        return linkInputPort.delete(id);}
    @PutMapping
    public LinkResponse update(@RequestBody Link  link){
        return linkInputPort.update(link);}
}
