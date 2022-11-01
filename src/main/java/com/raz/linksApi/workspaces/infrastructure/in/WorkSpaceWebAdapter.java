package com.raz.linksApi.workspaces.infrastructure.in;

import com.raz.linksApi.workspaces.domain.WorkSpace;
import com.raz.linksApi.workspaces.infrastructure.in.WorkSpaceInputPort;
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
    @PostMapping
    public WorkSpace  post(@RequestBody WorkSpace workSpace){
       return inputPort.create(workSpace);
    }
}