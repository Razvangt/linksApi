package com.raz.linksApi.workspaces.aplication;

import com.raz.linksApi.workspaces.domain.WorkSpace;
import com.raz.linksApi.workspaces.infrastructure.in.WorkSpaceInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
        return db.SearchAll().stream()
                .peek(workSpace -> workSpace.setLinks(null))
                .collect(Collectors.toList());
    }

    @Override
    public WorkSpace create(WorkSpace newWorkSpace) {
        return db.create(newWorkSpace);
    }

    @Override
    public WorkSpace update(WorkSpace updateWorkSpace) {
        return db.update(updateWorkSpace);
    }

    @Override
    public WorkSpaceResponse delete(String id) {
        Boolean res = db.delete(UUID.fromString(id));
        return WorkSpaceResponse.builder()
                                .response(res? "deleted" : "error")
                                .build();
    }

    @Override
    public WorkSpaceResponse findByID(String id) {
        Optional<WorkSpace> result =  db.findById(UUID.fromString(id));
        if(result.isEmpty()){
            return  WorkSpaceResponse.builder().response("Not Found").build();
        }
        WorkSpaceDto spaceDto = WorkSpaceDto.builder()
                                            .spaceId(result.get().getSpaceId())
                                            .title(result.get().getTitle())
                                            .links(null).build();
        return WorkSpaceResponse.builder().space(spaceDto).response("Found").build();
    }
}