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
@Table(name = "owner_link")
@Data
public class OwnerLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_link_id")
    private Long ownerLinkId;
    @Column(name = "owner_link_url")
    private String ownerLinkUrl;
    @Column(name = "owner_link_name")
    private String ownerLinkName;
    @Column(name = "owner_link_photo")
    private String ownerLinkPhoto;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId",nullable = false)
    @JsonIgnore
    private Owner owner;
}
