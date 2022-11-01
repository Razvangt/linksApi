package com.raz.linksApi.workspaces.aplication;

import com.raz.linksApi.workspaces.domain.WorkSpace;
import com.raz.linksApi.workspaces.domain.WorkSpaceRepository;
import com.raz.linksApi.workspaces.infrastructure.WorkSpaceInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkSpaceCrudUseCase implements WorkSpaceInputPort {
    private final WorkSpaceRepository db;
    @Autowired
    public WorkSpaceCrudUseCase(WorkSpaceRepository db){
        this.db = db;
    }
    @Override
    public List<WorkSpace> findAll() {
        return db.SearchAll();
    }

    @Override
    public WorkSpace create(WorkSpace newWorkSpace) {
        return null;
    }

    @Override
    public WorkSpace update(WorkSpace updateWorkSpace) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }
}