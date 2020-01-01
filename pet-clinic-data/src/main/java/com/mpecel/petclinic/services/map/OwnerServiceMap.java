package com.mpecel.petclinic.services.map;

import com.mpecel.petclinic.model.Owner;
import com.mpecel.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;    // tbd
    }

}
