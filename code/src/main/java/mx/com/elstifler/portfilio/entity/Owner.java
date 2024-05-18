package mx.com.elstifler.portfilio.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "owner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @Id
    @Column(name = "owner_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "owner_lastname")
    private String ownerLastName;
    @Column(name = "owner_position")
    private String ownerPosition;
    @Column(name = "owner_description")
    private String ownerDescription;
    @Column(name = "owner_about_me")
    private String ownerAboutMe;
    @Column(name = "owner_photo")
    private String ownerPhoto;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "owner",cascade = CascadeType.ALL)
    private List<OwnerSkill> ownerSkill;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "owner",cascade = CascadeType.ALL)
    private List<OwnerExperience> ownerExperience;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "owner",cascade = CascadeType.ALL)
    private List<OwnerLink> ownerLinks;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "owner",cascade = CascadeType.ALL)
    private List<OwnerProject> ownerProjects;





}
