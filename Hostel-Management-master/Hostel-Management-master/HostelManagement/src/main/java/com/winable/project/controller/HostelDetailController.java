package com.winable.project.controller;

//import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.winable.project.entity.HostelDetail;
import com.winable.project.service.HostelDetailService;


@RestController
@RequestMapping("/hostelDetail")
public class HostelDetailController {
  @Autowired
	private HostelDetailService HostelDetailService ;
	
	@GetMapping("/getAllHostelDetail")
	public ResponseEntity<List<HostelDetail>> getAllHostelDetail(){
		return ResponseEntity.ok(HostelDetailService.getAllHostelDetail());
		}
	
	@GetMapping("/getStudentById/{studentId}")
    public ResponseEntity<HostelDetail> getStudentById(@PathVariable int studentId) {
        Optional<HostelDetail> hostelDetail = HostelDetailService.getStudentById(studentId);
        return hostelDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@PostMapping("/registerStudent")
	public ResponseEntity registerStudent(@RequestBody HostelDetail hostelDetail) {
		HostelDetailService.RegisterStudent(hostelDetail);
        return ResponseEntity.ok().build();

	}
  @PutMapping("/updateHostelDetail/put")
  public ResponseEntity updateHostelDetail(@RequestBody HostelDetail updateHostelDetail) {
	  HostelDetail hostelDetail = HostelDetailService.updateHostelDetail(updateHostelDetail);
	  if (hostelDetail != null) {
		  return ResponseEntity.ok(hostelDetail);
	  }
	  return ResponseEntity.notFound().build();
  }
  
  @DeleteMapping("/deleteHostelDetailById/{studentId}")
  public ResponseEntity deleteHostelDetail(@PathVariable int studentId) {
	  HostelDetail hostelDetail = HostelDetailService.deleteHostelDetail(studentId);
	  if (hostelDetail != null) {
		  return ResponseEntity.ok(hostelDetail); 
	  }
	  return ResponseEntity.notFound().build();
  }
}

