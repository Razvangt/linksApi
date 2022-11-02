package com.raz.linksApi.links.infrastructure.out;



import com.raz.linksApi.links.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LinkAdapterJPA extends JpaRepository<Link, UUID> {
    
}
