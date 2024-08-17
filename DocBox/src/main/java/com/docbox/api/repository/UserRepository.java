package com.docbox.api.repository;

import com.docbox.api.entity.User;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.profilePhoto = :bs WHERE u.username = :userName")
    void updateProfilePhoto(String userName, byte[] bs);
}
