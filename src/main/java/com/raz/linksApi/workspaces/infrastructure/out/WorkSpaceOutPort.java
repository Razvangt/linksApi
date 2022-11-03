package com.raz.linksApi.workspaces.infrastructure.out;

import com.raz.linksApi.workspaces.domain.WorkSpace;
import com.raz.linksApi.workspaces.aplication.WorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class WorkSpaceOutPort implements WorkSpaceRepository {

    private final WorkSpaceAdapterJPA postgresDB;

    @Autowired
    public WorkSpaceOutPort(WorkSpaceAdapterJPA postgresDB) {
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

    
    @Override
    public Optional<WorkSpace> findById(UUID space_id) {
        return postgresDB.findById(space_id);
    }

    @Override
    public Boolean delete(UUID space_id) {
        if(findById(space_id).isEmpty()){
            return  false;
        }
         postgresDB.deleteById(space_id);
            return true;
    }

    @Override
    public WorkSpace update(WorkSpace updateWorkSpace) {
        return postgresDB.save(updateWorkSpace);
    }
}