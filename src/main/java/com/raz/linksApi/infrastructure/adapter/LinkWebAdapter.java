package com.raz.linksApi.infrastructure.adapter;

import com.raz.linksApi.aplication.LinkResponse;
import com.raz.linksApi.domain.Link;
import com.raz.linksApi.infrastructure.LinkInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "link")
public class LinkWebAdapter {
    @Autowired
    LinkInputPort linkInputPort;
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
