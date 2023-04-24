package com.nawaz.server.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nawaz.server.models.ImageComment;
import com.nawaz.server.repo.ImageCommentRepo;

@Service
public class ImageCommentService {
	@Autowired
	ImageCommentRepo imageCommentRepo;

	public ImageComment create(ImageComment imageCommentReq) {		
		boolean res = imageCommentRepo.createImageComment(imageCommentReq);
		System.out.println("res : "+res);
		
		return imageCommentReq;
	}

	
	public List<ImageComment> get() {		
		List<ImageComment> res = imageCommentRepo.getAllImageComments();
		System.out.println("res : "+res);
		
		return res;
	}
  
	public ImageComment get(int id) {		
		ImageComment res = imageCommentRepo.getImageCommentById(id);
		System.out.println("res : "+res);
		
		return res;
	}

	
	public List<ImageComment> getLocationImageComments(String locationUuid) {		
		List<ImageComment> res = imageCommentRepo.getLocationImageComments(locationUuid);
		System.out.println("res : "+res);
		
		return res;
	}
	
}
