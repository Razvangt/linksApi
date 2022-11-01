package com.raz.linksApi.links.domain;

import com.raz.linksApi.workspaces.domain.WorkSpace;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table(name = "link")
public class Link{

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uuid2")
    private UUID id;
    private String name;
    private String url;

    @ManyToOne
    @JoinColumn(name = space_id)
    private WorkSpace workSpace;
}