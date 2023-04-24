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
import com.nawaz.server.services.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentControllerImpl {
	@Autowired
	CommentService commentService;
	
	@PostMapping("/create")
	public ResponseEntity<Comment> createComment(@RequestBody Comment commentReq) {		
		Comment res = commentService.create(commentReq);
		System.out.println("res : "+res);
		
		ResponseEntity<Comment> responseEntity = new ResponseEntity<>(res, 
				HttpStatus.CREATED);
		
		return responseEntity;
	}
	

	
	@GetMapping("")
	public ResponseEntity<List<Comment>> getComment() {		
		List<Comment> res = commentService.get();
		System.out.println("res : "+res);
		
		ResponseEntity<List<Comment>> responseEntity = new ResponseEntity<List<Comment>>(res, 
				HttpStatus.ACCEPTED);
		
		return responseEntity;
	}


	@GetMapping("/{id}")
	public ResponseEntity<Comment> getComment(@PathVariable int id) {		
		Comment res = commentService.get(id);
		System.out.println("res : "+res);
		
		ResponseEntity<Comment> responseEntity = new ResponseEntity<>(res, 
				HttpStatus.ACCEPTED);
		
		return responseEntity;
	}
	
	@GetMapping("/byLocations/{locationUuid}")
	public ResponseEntity<List<Comment>> getLocationComments(@PathVariable String locationUuid) {		
		List<Comment> res = commentService.getLocationComments(locationUuid);
		System.out.println("res : "+res);
		
		ResponseEntity<List<Comment>> responseEntity = new ResponseEntity<List<Comment>>(res, 
				HttpStatus.ACCEPTED);
		
		return responseEntity;
	}



}
