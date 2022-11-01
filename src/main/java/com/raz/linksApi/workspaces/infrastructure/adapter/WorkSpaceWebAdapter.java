package com.raz.linksApi.workspaces.infrastructure.adapter;

import com.raz.linksApi.workspaces.domain.WorkSpace;
import com.raz.linksApi.workspaces.infrastructure.WorkSpaceInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "workspace")
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
}