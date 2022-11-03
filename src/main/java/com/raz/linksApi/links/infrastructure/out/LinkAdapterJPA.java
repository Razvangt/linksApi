package com.raz.linksApi.links.infrastructure.out;



import com.raz.linksApi.links.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LinkAdapterJPA extends JpaRepository<Link, UUID> {
    @Query(
            value = "Select * from link u where u.space_id = ?1",
            nativeQuery = true)
    List<Link> findAllByWorkspaceId(UUID uuid);
}
