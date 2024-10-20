package com.winable.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.winable.project.entity.HostelDetail;

@Repository
public interface HostelDetailRepo extends JpaRepository<HostelDetail,Integer> {

}
