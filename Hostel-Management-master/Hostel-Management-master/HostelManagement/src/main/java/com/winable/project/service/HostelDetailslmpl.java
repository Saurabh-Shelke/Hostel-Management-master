package com.winable.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.winable.project.entity.HostelDetail;
import com.winable.project.repository.HostelDetailRepo;


import jakarta.annotation.PostConstruct;

@Service
public class HostelDetailslmpl implements HostelDetailService {

	@Autowired
	private HostelDetailRepo hostelDetailRepo;
	
	@Override
	public List<HostelDetail> getAllHostelDetail(){
		return hostelDetailRepo.findAll();
	}
	
	@Override
    public Optional<HostelDetail> getStudentById(int studentId) {
		return hostelDetailRepo.findById(studentId);
	   }
		
	@Override
	public void RegisterStudent(HostelDetail hostelDetail) {
		hostelDetailRepo.save(hostelDetail);
	}
	
	@Override
	public HostelDetail deleteHostelDetail(int studentId) {
		Optional<HostelDetail> hostelDetail = hostelDetailRepo.findById(studentId);
		 if (hostelDetail.isPresent()) {
			 hostelDetailRepo.deleteById(studentId);
	            return hostelDetail.get();
	        } else {
	            return null;
	        }
	    }
	@Override
	public HostelDetail updateHostelDetail(HostelDetail hostelDetail) {
		Optional<HostelDetail> eXhostelDetail = hostelDetailRepo.findById(hostelDetail.getStudentId());
		if(eXhostelDetail.isPresent()) {
			System.out.println("Present");
			eXhostelDetail.get().setStudentId(hostelDetail.getStudentId());
			eXhostelDetail.get().setRoomNo(hostelDetail.getRoomNo());
			eXhostelDetail.get().setFloorNo(hostelDetail.getFloorNo());
			eXhostelDetail.get().setBuildingName(hostelDetail.getBuildingName());
			hostelDetailRepo.save(eXhostelDetail.get());
		}
		return hostelDetail;
	}
	}

