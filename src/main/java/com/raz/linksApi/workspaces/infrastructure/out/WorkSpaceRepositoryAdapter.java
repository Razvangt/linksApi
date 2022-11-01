package com.raz.linksApi.workspaces.infrastructure.out;

import com.raz.linksApi.workspaces.domain.WorkSpace;
import com.raz.linksApi.workspaces.aplication.WorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
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

    @Override
    public WorkSpace create(WorkSpace newWorkspace) {
        return postgresDB.save(newWorkspace);
    }
}