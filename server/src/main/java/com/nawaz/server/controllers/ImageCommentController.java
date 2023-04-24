package com.nawaz.server.controllers;

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

import com.nawaz.server.models.Comment;
import com.nawaz.server.models.ImageComment;
import com.nawaz.server.services.ImageCommentService;

@CrossOrigin
@RestController
@RequestMapping("/imageComments")
public class ImageCommentController {
	@Autowired
	ImageCommentService imageCommentService;
	
	@PostMapping("/create")
	public ResponseEntity<ImageComment> createImageComment(@RequestBody ImageComment imageCommentReq) {		
		ImageComment res = imageCommentService.create(imageCommentReq);
		System.out.println("res : "+res);
		
		ResponseEntity<ImageComment> responseEntity = new ResponseEntity<>(res, 
				HttpStatus.CREATED);
		
		return responseEntity;
	}
	

	
	@GetMapping("")
	public ResponseEntity<List<ImageComment>> getImageComment() {		
		List<ImageComment> res = imageCommentService.get();
		System.out.println("res : "+res);
		
		ResponseEntity<List<ImageComment>> responseEntity = new ResponseEntity<List<ImageComment>>(res, 
				HttpStatus.ACCEPTED);
		
		return responseEntity;
	}


	@GetMapping("/{id}")
	public ResponseEntity<ImageComment> getImageComment(@PathVariable int id) {		
		ImageComment res = imageCommentService.get(id);
		System.out.println("res : "+res);
		
		ResponseEntity<ImageComment> responseEntity = new ResponseEntity<>(res, 
				HttpStatus.ACCEPTED);
		
		return responseEntity;
	}
	
	@GetMapping("/byLocations/{locationUuid}")
	public ResponseEntity<List<ImageComment>> getLocationImageComments(@PathVariable String locationUuid) {		
		List<ImageComment> res = imageCommentService.getLocationImageComments(locationUuid);
		System.out.println("res : "+res);
		
		ResponseEntity<List<ImageComment>> responseEntity = new ResponseEntity<List<ImageComment>>(res, 
				HttpStatus.ACCEPTED);
		
		return responseEntity;
	}



}
