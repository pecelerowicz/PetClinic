package com.mpecel.petclinic.services.map;

import com.mpecel.petclinic.model.Vet;
import com.mpecel.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

}
