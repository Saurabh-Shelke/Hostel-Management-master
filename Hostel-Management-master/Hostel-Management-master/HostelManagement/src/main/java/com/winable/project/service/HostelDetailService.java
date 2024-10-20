package com.winable.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.winable.project.entity.HostelDetail;


@Service
public interface HostelDetailService {
	
    List<HostelDetail> getAllHostelDetail();
    
    Optional<HostelDetail> getStudentById(int studentId);
    
    void RegisterStudent(HostelDetail hostelDetail);
    
    HostelDetail updateHostelDetail(HostelDetail hostelDetail);
    
    HostelDetail deleteHostelDetail(int studentId);
    }