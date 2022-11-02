package com.raz.linksApi.workspaces.aplication;

import com.raz.linksApi.links.domain.Link;
import com.raz.linksApi.workspaces.domain.WorkSpace;
import com.raz.linksApi.workspaces.infrastructure.in.WorkSpaceInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkSpaceService implements WorkSpaceInputPort {
    private final WorkSpaceRepository db;
    @Autowired
    public WorkSpaceService(WorkSpaceRepository db){
        this.db = db;
    }
    @Override
    public List<WorkSpace> findAll() {
        List<WorkSpace> data =  db.SearchAll();
        data = data.stream()
        .peek(workSpace -> workSpace.setLinks(workSpace
            .getLinks().stream()
            .peek(link -> link.setWorkspace(null))
            .collect(Collectors.toSet())))
        .collect(Collectors.toList());
        return data;
    }

    @Override
    public WorkSpace create(WorkSpace newWorkSpace) {
        return db.create(newWorkSpace);
    }

    @Override
    public WorkSpace update(WorkSpace updateWorkSpace) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public WorkSpace findByID(String id) {
        return null;
    }
}