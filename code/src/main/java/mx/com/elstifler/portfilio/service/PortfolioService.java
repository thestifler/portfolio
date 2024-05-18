package mx.com.elstifler.portfilio.service;

import mx.com.elstifler.portfilio.entity.Owner;

public interface PortfolioService {
    Owner getOwnerbyId(Long ownerId);
}
