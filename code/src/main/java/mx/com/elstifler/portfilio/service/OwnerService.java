package mx.com.elstifler.portfilio.service;

import java.util.UUID;

import mx.com.elstifler.portfilio.entity.Owner;

public interface OwnerService {
    Owner findOwnerById(UUID ownerId);
}
