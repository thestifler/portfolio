package mx.com.elstifler.portfilio.service;

import java.util.UUID;

import mx.com.elstifler.portfilio.entity.Owner;

public interface PortfolioService {
    Owner getOwnerbyId(UUID ownerId);
}
