package com.nawaz.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nawaz.server.models.Comment;
import com.nawaz.server.models.ImageComment;
import com.nawaz.server.repo.CommentRepo;

@Service
public class CommentService{
	@Autowired
	CommentRepo commentRepo;

	public Comment create(Comment commentReq) {		
		boolean res = commentRepo.createComment(commentReq);
		System.out.println("res : "+res);
		
		return commentReq;
	}
	

	
	public List<Comment> get() {		
		List<Comment> res = commentRepo.getAllComments();
		System.out.println("res : "+res);
		
		return res;
	}

	public Comment get(int id) {		
		Comment res = commentRepo.getCommentById(id);
		System.out.println("res : "+res);
		
		return res;
	}
	
	public List<Comment> getLocationComments(String locationUuid) {		
		List<Comment> res = commentRepo.getLocationComments(locationUuid);
		System.out.println("res : "+res);
		
		return res;
	}

}
