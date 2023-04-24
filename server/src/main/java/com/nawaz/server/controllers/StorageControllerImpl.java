// package com.nawaz.server.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.ByteArrayResource;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.multipart.MultipartFile;

// import com.nawaz.server.services.StorageServiceImpl;
// import com.nawaz.server.services.UserServiceImpl;

// @RestController
// @RequestMapping("/file")
// public class StorageControllerImpl {

//     @Autowired
//     private StorageServiceImpl service;
    
//     @Autowired
//     private UserServiceImpl userServiceImpl;


//     @PostMapping("/upload")
//     public ResponseEntity<String> uploadFile(@RequestParam(value = "userId") int userId, 
//     		@RequestParam(value = "file") MultipartFile file) {
//     	String fileName = service.uploadFile(file);
    	
//     	userServiceImpl.uploadProfilePic(userId, fileName);
    	
//         return new ResponseEntity<>(fileName, HttpStatus.OK);
//     }

//     @GetMapping("/downloadByUserId/{userId}")
//     public ResponseEntity<ByteArrayResource> downloadByUserId(@PathVariable int userId) {
//     	String fileName = userServiceImpl.getProfilePicById(userId);
//     	if(fileName!=null) {
//             byte[] data = service.downloadFile(fileName);
//             ByteArrayResource resource = new ByteArrayResource(data);  
//             return ResponseEntity
//                     .ok()
//                     .contentLength(data.length)
//                     .header("Content-type", "application/octet-stream")
//                     .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
//                     .body(resource);
//     	}else {
//             return ResponseEntity
//                     .ok()
//                     .contentLength(0)
//                     .header("Content-type", "application/octet-stream")
//                     .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
//                     .body(null);
//     	}
//     }
    
//     @GetMapping("/downloadByFIleName/{fileName}")
//     public ResponseEntity<ByteArrayResource> downloadByFIleName(@PathVariable String fileName) {
//         byte[] data = service.downloadFile(fileName);
//         ByteArrayResource resource = new ByteArrayResource(data);
//         return ResponseEntity
//                 .ok()
//                 .contentLength(data.length)
//                 .header("Content-type", "application/octet-stream")
//                 .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
//                 .body(resource);
//     }

//     @DeleteMapping("/delete/{fileName}")
//     public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
//         return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
//     }
// }