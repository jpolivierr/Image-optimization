package com.appvenir.imageoptimization.domain.user.model;

import java.util.List;

import com.appvenir.imageoptimization.domain.common.Auditable;
import com.appvenir.imageoptimization.domain.imageDetails.model.ImageDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends Auditable{
    
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy = "users")
    private List<ImageDetails> imageDetails;
}
