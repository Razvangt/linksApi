package com.raz.linksApi.workspaces.infrastructure.in;

import com.raz.linksApi.workspaces.aplication.WorkSpaceResponse;
import com.raz.linksApi.workspaces.domain.WorkSpace;

import java.util.List;
public interface WorkSpaceInputPort {
   List<WorkSpace>    findAll();
   WorkSpace         create(WorkSpace newWorkSpace);
   WorkSpace          update(WorkSpace updateWorkSpace);
   WorkSpaceResponse   delete(String id);

   WorkSpaceResponse findByID(String id);

}