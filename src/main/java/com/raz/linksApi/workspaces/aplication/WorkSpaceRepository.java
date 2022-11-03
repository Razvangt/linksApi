package com.raz.linksApi.workspaces.aplication;


import com.raz.linksApi.workspaces.domain.WorkSpace;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkSpaceRepository {
  List<WorkSpace> SearchAll();
  WorkSpace create(WorkSpace newWorkspace);
  Optional<WorkSpace> findById(UUID space_id);
  Boolean delete(UUID space_id);
  WorkSpace update(WorkSpace updateWorkSpace);
}