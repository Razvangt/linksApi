package com.raz.linksApi.infrastructure.adapter;

import com.raz.linksApi.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LinkAdapterJPA extends JpaRepository<Link, UUID> {
}
