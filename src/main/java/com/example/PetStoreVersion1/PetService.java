package com.example.PetStoreVersion1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;

	public Pet createPet(Pet pet) {
		return petRepository.save(pet);
	}
	
	public List<Pet> getAllPets(){
		return petRepository.findAll();
	}
	
	public Optional<Pet> getPetById(Long id){
		return petRepository.findById(id);
	}
	
	public Pet updatePet(Long id, Pet updatePet) {
		updatePet.setId(id);
		return petRepository.save(updatePet);
	}
	
	public void deletePet(Long id) {
		petRepository.deleteById(id);
	}
}
