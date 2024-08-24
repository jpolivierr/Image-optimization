package com.appvenir.imageoptimization.domain.imageDetails.model;

import java.util.ArrayList;
import java.util.List;
import com.appvenir.imageoptimization.domain.common.Auditable;
import com.appvenir.imageoptimization.domain.user.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "image_details")
@Getter
@Setter
public class ImageDetails extends Auditable{

    @Column(nullable = false)
    private String title;

    private String description;
    
    private List<String> tags;

    private List<String> category;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private String path;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "users_image_details",
            joinColumns = @JoinColumn(name = "image_details_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
            )
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }
} 