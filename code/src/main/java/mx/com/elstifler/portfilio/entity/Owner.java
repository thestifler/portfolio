package mx.com.elstifler.portfilio.entity;

import java.util.List;
import java.util.UUID;

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
@Table(name = "owners")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @Id
    @Column(name = "owner_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID ownerId;
    @Column(name = "name")
    private String ownerName;
    @Column(name = "lastname")
    private String ownerLastName;
    @Column(name = "position")
    private String ownerPosition;
    @Column(name = "description")
    private String ownerDescription;
    @Column(name = "about_me")
    private String ownerAboutMe;
    @Column(name = "photo")
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
