package com.raz.linksApi.workspaces.aplication;


import com.raz.linksApi.workspaces.domain.WorkSpace;

import java.util.List;

public interface WorkSpaceRepository {
  List<WorkSpace> SearchAll();
  WorkSpace create(WorkSpace newWorkspace);
}