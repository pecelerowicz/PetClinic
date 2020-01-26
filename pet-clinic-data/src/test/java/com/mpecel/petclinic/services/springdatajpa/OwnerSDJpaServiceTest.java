package com.mpecel.petclinic.services.springdatajpa;

import com.mpecel.petclinic.model.Owner;
import com.mpecel.petclinic.repositories.OwnerRepository;
import com.mpecel.petclinic.repositories.PetRepository;
import com.mpecel.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME1 = "Kowalski";
    public static final String LAST_NAME2 = "Nowak";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner o1;
    Owner o2;
    Set<Owner> owners;

    @BeforeEach
    void setUp() {
        o1 = Owner.builder().id(1l).lastName(LAST_NAME1).build();
        o2 = Owner.builder().id(2l).lastName(LAST_NAME2).build();
        owners = new HashSet<>();
        owners.add(o1);
        owners.add(o2);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(o1);

        Owner returnedOwner = service.findByLastName(LAST_NAME1);
        assertEquals(LAST_NAME1 , returnedOwner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> returnedOwners = service.findAll();
        assertEquals(2, returnedOwners.size());
        verify(ownerRepository).findAll();

    }

    @Test
    void findById() {

        when(ownerRepository.findById(1L)).thenReturn(Optional.of(o1));
        when(ownerRepository.findById(2L)).thenReturn(Optional.of(o2));

        Owner returned1 = service.findById(1L);
        Owner returned2 = service.findById(2L);

        assertEquals(o1.getId(), returned1.getId());
        assertEquals(o2.getId(), returned2.getId());

    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(3L).build();
        when(ownerRepository.save(any())).thenReturn(ownerToSave);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        service.delete(o1);
        verify(ownerRepository).delete(o1);
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(1L);
    }
}