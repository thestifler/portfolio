package mx.com.elstifler.portfilio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "project_link")
@Data
public class OwnerProjectLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_link_id")
    private Long projectLinkId;
    @Column(name = "project_link_name")
    private String projectLinkName;
    @Column(name = "project_link_url")
    private String projectLinkUrl;
    @Column(name = "project_link_photo")
    private String projectLinkPhoto;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProjectId",nullable = false)
    @JsonIgnore
    private OwnerProject ownerProject;
}
