package com.mpecel.petclinic.services.map;

import com.mpecel.petclinic.model.Owner;
import com.mpecel.petclinic.model.Pet;
import com.mpecel.petclinic.services.OwnerService;
import com.mpecel.petclinic.services.PetService;
import com.mpecel.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"}) // if we had only map, default would be inactive in case of no profile set. That's why (to keep default active) we need to specify it explicitly.
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null) {

            if(object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null) {
                        if(pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("PetType is required");
                    }

                    if(pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId()); // over the top...
                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }

    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;    // tbd
    }
}
