package com.raz.linksApi.workspaces.infrastructure.adapter;

import com.raz.linksApi.workspaces.domain.WorkSpace;
import com.raz.linksApi.workspaces.domain.WorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkSpaceRepositoryAdapter implements WorkSpaceRepository {

    private final WorkSpaceAdapterJPA postgresDB;

    @Autowired
    public WorkSpaceRepositoryAdapter(WorkSpaceAdapterJPA postgresDB) {
        this.postgresDB = postgresDB;
    }


    @Override
    public List<WorkSpace> SearchAll() {
        return postgresDB.findAll();
    }
}