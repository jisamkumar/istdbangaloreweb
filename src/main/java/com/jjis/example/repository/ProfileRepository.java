package com.jjis.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jjis.example.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}