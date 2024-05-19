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
@Table(name = "owner_experience_details")
@Data
public class OwnerExperienceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "experience_detail_id")
    private UUID ownerExperienceDetailId;
    @Column(name = "experience_detail_description")
    private String ownerExperienceDetailDescription;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experience_id")
    @JsonIgnore
    private OwnerExperience ownerExperience;
}
