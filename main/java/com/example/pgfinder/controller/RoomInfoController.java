package com.example.pgfinder.controller;

import com.example.pgfinder.models.repository.RoomInfoRepository;
import com.example.pgfinder.models.PGDetails;
import com.example.pgfinder.models.RoomInfo;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pgfinder.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class RoomInfoController {
	
	@Autowired
	private RoomInfoRepository roominforepository;
	
	@GetMapping("/roominfo")
	public List<RoomInfo> getAllRoomInfo(){
		return roominforepository.findAll();
	}
	
	//create roominfo rest api
	@PostMapping("/roominfo")
	public List<RoomInfo> createRoomInfo(@RequestBody final RoomInfo roominfo)
	{
		RoomInfo room = roominforepository.save(roominfo);
		return roominforepository.findAll();
	}
	
	@GetMapping("/roominfo/{id}")
	public ResponseEntity<RoomInfo> getRoomInfoById(@PathVariable Long id)
	{
		RoomInfo roominfo = roominforepository.findById(id)
				.orElseThrow( ()-> new ResourceNotFoundException("RoomInfo not exist with the id:" + id));
		return ResponseEntity.ok(roominfo);
	}
}
