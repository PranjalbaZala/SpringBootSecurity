package com.example.pgfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pgfinder.exception.ResourceNotFoundException;
import com.example.pgfinder.models.PGDetails;
import com.example.pgfinder.models.repository.PGDetailsRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class PGDetailsController {
	
	@Autowired
	private PGDetailsRepository pgdetailsRepository;
	
	//get all pgdetails
	@GetMapping("/pgdetails")
	public List<PGDetails> getAllPGDetails(){
		return pgdetailsRepository.findAll();
	}
	
	//create pgdetails rest api
	@PostMapping("/pgdetails")
	public PGDetails createPGDetails(@RequestBody PGDetails pgdetails)
	{
		return pgdetailsRepository.save(pgdetails);
	}
	
	@GetMapping("/pgdetails/{id}")
	public ResponseEntity<PGDetails> getPGDetailsById(@PathVariable Long id) 
	{
		PGDetails pgdetails = pgdetailsRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("PGDetails not exist with id:" + id));
		
		return ResponseEntity.ok(pgdetails);
		
	}
	
	//build update employee rest api
	@PutMapping("/pgdetails/{id}")
	public ResponseEntity<PGDetails> updatePGDetails(@PathVariable Long id,@RequestBody PGDetails pgdetails ) {
		PGDetails updatePGDetails = pgdetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("PGDetails not exist with id:" + id));
		
		updatePGDetails.setPg_name(pgdetails.getPg_name());
		updatePGDetails.setPg_address(pgdetails.getPg_address());
		updatePGDetails.setGender(pgdetails.getGender());
		updatePGDetails.setCountry(pgdetails.getCountry());
		updatePGDetails.setState(pgdetails.getState());
		updatePGDetails.setCity(pgdetails.getCity());
		updatePGDetails.setPhone_no(pgdetails.getPhone_no());
		updatePGDetails.setDeposit_amt(pgdetails.getDeposit_amt());
		updatePGDetails.setNotice_period(pgdetails.getNotice_period());
		updatePGDetails.setFood_avail(pgdetails.getFood_avail());
		updatePGDetails.setWifi_avail(pgdetails.getWifi_avail());
		
		pgdetailsRepository.save(updatePGDetails);
		
		return ResponseEntity.ok(updatePGDetails);
	}
	
	//delete delete rest api
	@DeleteMapping("/pgdetails/{id}")
	public ResponseEntity<HttpStatus> deletePGDetails(@PathVariable Long id)
	{
		PGDetails pgdetails = pgdetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("PGDetails not exist with id:" + id));
		
		pgdetailsRepository.delete(pgdetails);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
