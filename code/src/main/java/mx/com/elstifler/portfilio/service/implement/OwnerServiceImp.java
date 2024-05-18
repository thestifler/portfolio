package mx.com.elstifler.portfilio.service.implement;

import org.springframework.stereotype.Service;

import mx.com.elstifler.portfilio.entity.Owner;
import mx.com.elstifler.portfilio.repository.OwnerRepository;
import mx.com.elstifler.portfilio.service.OwnerService;

@Service
public class OwnerServiceImp implements OwnerService{

    private final OwnerRepository ownerRepository;

    public OwnerServiceImp(OwnerRepository ownerRepository){
        this.ownerRepository=ownerRepository;
    }

    @Override
    public Owner findOwnerById(Long ownerId) {
        return ownerRepository.findOwnerById(ownerId);
    }
}
