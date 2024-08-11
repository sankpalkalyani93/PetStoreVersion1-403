package com.example.PetStoreVersion1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public List<Pet> getAllPets() {
		return petRepository.findAll();
	}
	
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}
	
	// method to fetch a pet by id
	public Pet getPetById(Long id) {
		return petRepository.findById(id).orElse(null);
	}
}
