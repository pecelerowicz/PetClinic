package com.mpecel.petclinic.services.map;

import com.mpecel.petclinic.model.Pet;
import com.mpecel.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
