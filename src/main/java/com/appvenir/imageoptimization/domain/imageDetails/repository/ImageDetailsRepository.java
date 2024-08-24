package com.appvenir.imageoptimization.domain.imageDetails.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appvenir.imageoptimization.domain.imageDetails.model.ImageDetails;

@Repository
public interface ImageDetailsRepository extends JpaRepository<ImageDetails,Long> {
    
}
