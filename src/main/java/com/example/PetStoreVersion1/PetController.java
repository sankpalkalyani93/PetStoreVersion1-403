package com.example.PetStoreVersion1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pets")
public class PetController {

	@Autowired
	private PetService petService;

	@PostMapping
	public ResponseEntity<Pet> createPet(@RequestBody Pet pet){
		Pet createdPet = petService.createPet(pet);
		return new ResponseEntity<>(createdPet, HttpStatus.CREATED);		
	}
	
	@GetMapping
	public ResponseEntity<List<Pet>> getAllPets(){
		List<Pet> petList = petService.getAllPets();
		return new ResponseEntity<>(petList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pet> getPetyById(@PathVariable Long id){
		Optional<Pet> pet = petService.getPetById(id);
		return pet.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet pet){
		Pet updatedPet = petService.updatePet(id, pet);
		if(updatedPet != null) {
			return ResponseEntity.ok(updatedPet);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePet(@PathVariable Long id) {
		petService.deletePet(id);
		return ResponseEntity.noContent().build();
	}
	
}