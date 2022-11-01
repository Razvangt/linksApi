package com.raz.linksApi.workspaces.infrastructure.adapter;

import com.raz.linksApi.workspaces.domain.WorkSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkSpaceAdapterJPA extends JpaRepository<WorkSpace, UUID> {

}