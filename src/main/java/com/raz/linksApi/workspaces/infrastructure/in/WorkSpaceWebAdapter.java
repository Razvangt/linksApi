package com.raz.linksApi.workspaces.infrastructure.in;

import com.raz.linksApi.workspaces.aplication.WorkSpaceResponse;
import com.raz.linksApi.workspaces.domain.WorkSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/workspace")
public class WorkSpaceWebAdapter {
    private final WorkSpaceInputPort inputPort;

    @Autowired
    public WorkSpaceWebAdapter(WorkSpaceInputPort inputPort) {
        this.inputPort = inputPort;
    }
    @GetMapping
    public List<WorkSpace> getAll(){
       return inputPort.findAll();
    }
    @GetMapping("/{space_id}")
    public WorkSpaceResponse getById(@PathVariable String space_id){
        return inputPort.findByID(space_id);
    }
    @PostMapping
    public WorkSpace  post(@RequestBody WorkSpace workSpace){
       return inputPort.create(workSpace);
    }

    @DeleteMapping("/{space_id}")
    public WorkSpaceResponse  delete(@PathVariable String space_id){
        return inputPort.delete(space_id);
    }
}