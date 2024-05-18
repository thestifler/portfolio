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
@Table(name = "owner_experience_skill")
@Data
public class OwnerExperienceSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_experience_skill_id")
    private Long ownerExperienceSkillId;
    @Column(name = "owner_experience_skill_name")
    private String ownerExperienceSkillName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerExperienceId",nullable = false)
    @JsonIgnore
    private OwnerExperience ownerExperience;
}
