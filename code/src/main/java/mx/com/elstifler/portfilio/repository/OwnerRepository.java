package mx.com.elstifler.portfilio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.elstifler.portfilio.entity.Owner;


public interface OwnerRepository  extends JpaRepository<Owner,Long>{


    @Query("SELECT t FROM Owner t WHERE t.ownerId= :ownerId ")
    Owner findOwnerById(@Param("ownerId") Long ownerId);
}
