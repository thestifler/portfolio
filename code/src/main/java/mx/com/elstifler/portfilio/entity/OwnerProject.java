package mx.com.elstifler.portfilio.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "project")
@Data
public class OwnerProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long ownerProjectId;
    @Column(name = "project_name")
    private String ownerProjectName;
    @Column(name = "project_description")
    private String ownerProjectDescription;
    @Column(name = "project_photo")
    private String onwerProjectPhoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId",nullable = false)
    @JsonIgnore
    private Owner owner;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ownerProject",cascade = CascadeType.ALL)
    private List<OwnerProjectLink> ownerProjectLinks;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ownerProject",cascade = CascadeType.ALL)
    private List<OwnerProjectSkill> ownerProjectSkills;

}
