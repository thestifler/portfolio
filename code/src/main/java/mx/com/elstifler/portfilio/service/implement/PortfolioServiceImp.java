package mx.com.elstifler.portfilio.service.implement;

import org.springframework.stereotype.Service;

import mx.com.elstifler.portfilio.entity.Owner;
import mx.com.elstifler.portfilio.service.PortfolioService;

@Service
public class PortfolioServiceImp implements PortfolioService{

    private final OwnerServiceImp ownerServiceImp;

    public PortfolioServiceImp(OwnerServiceImp ownerServiceImp){
        this.ownerServiceImp=ownerServiceImp;
    }
    @Override
    public Owner getOwnerbyId(Long ownerId) {
         return ownerServiceImp.findOwnerById(ownerId);
    }
}
