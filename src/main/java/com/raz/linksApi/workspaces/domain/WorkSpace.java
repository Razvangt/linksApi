package com.raz.linksApi.workspaces.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.raz.linksApi.links.domain.Link;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Data
@Entity
@Table(name = "workspace")
public class WorkSpace {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uuid2")
    @Column(name = "space_id")
    private UUID spaceId;
    private String title;
    @OneToMany(mappedBy = "workspace",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Link> links = new HashSet<>();
}