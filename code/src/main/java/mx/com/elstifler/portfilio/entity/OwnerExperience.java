package mx.com.elstifler.portfilio.entity;

import java.util.Date;
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
@Table(name = "owner_experience")
@Data
public class OwnerExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_experience_id")
    private Long ownerExperienceId;
    @Column(name = "owner_experience_name")
    private String ownerExperienceName;
    @Column(name = "owner_experience_description")
    private String ownerExperienceDescription;
    @Column(name = "owner_experience_initial_date")
    private Date ownerExpereinceInitialDate;
    @Column(name = "owner_experience_end_date")
    private Date ownerExpereinceEndDate;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId",nullable = false)
    @JsonIgnore
    private Owner owner;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ownerExperience",cascade = CascadeType.ALL)
    private List<OwnerExperienceSkill> ownerExperienceSkills;
}
