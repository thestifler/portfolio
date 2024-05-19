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
@Table(name = "owner_experience_skills")
@Data
public class OwnerExperienceSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_skill_id")
    private UUID ownerExperienceSkillId;
    @Column(name = "experience_skill_name")
    private String ownerExperienceSkillName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ExperienceId",nullable = false)
    @JsonIgnore
    private OwnerExperience ownerExperience;
}
