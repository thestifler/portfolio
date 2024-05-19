package mx.com.elstifler.portfilio.entity;

import java.util.UUID;

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
@Table(name = "project_skills")
@Data
public class OwnerProjectSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_skill_id")
    private UUID projectSkillId;
    @Column(name = "project_skill_name")
    private String projectSkillName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProjectId",nullable = false)
    @JsonIgnore
    private OwnerProject ownerProject;
}
