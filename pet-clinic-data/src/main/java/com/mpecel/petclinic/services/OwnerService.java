package com.mpecel.petclinic.services;

import com.mpecel.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
