package com.jjis.example.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jjis.example.entity.Profile;
import com.jjis.example.service.ProfileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
    name = "Profile API",
    description = "Operations related to ISTD Profile management"
)
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    // =========================================================
    // CREATE
    // =========================================================

    @Operation(
        summary = "Create Profile",
        description = "Creates a new ISTD Profile"
    )
    @PostMapping
    public Profile create(@RequestBody Profile profile) {
        return service.createProfile(profile);
    }

    // =========================================================
    // READ ALL
    // =========================================================

    @Operation(
        summary = "Get all Profiles",
        description = "Returns all registered ISTD Profiles"
    )
    @GetMapping
    public List<Profile> getAll() {
        return service.getAllProfiles();
    }

    // =========================================================
    // READ BY ID
    // =========================================================

    @Operation(
        summary = "Get Profile by Id",
        description = "Returns a Profile using its Profile Id"
    )
    @GetMapping("/{id}")
    public Profile getById(
            @Parameter(
                description = "Profile Id",
                required = true
            )
            @PathVariable Long id) {

        return service.getProfileById(id);
    }

    // =========================================================
    // UPDATE
    // =========================================================

    @Operation(
        summary = "Update Profile",
        description = "Updates an existing ISTD Profile"
    )
    @PutMapping("/{id}")
    public Profile update(
            @Parameter(
                description = "Profile Id",
                required = true
            )
            @PathVariable Long id,
            @RequestBody Profile profile) {

        return service.updateProfile(id, profile);
    }
    @Operation(
        summary = "Create Member Profile with uploaded files",
        description = "Creates a member profile and stores uploaded files on disk"
    )
    @PostMapping(value = "/multipart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Profile createMultipart(
            @RequestPart("profile") Profile profile,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestPart(value = "aadhaar", required = false) MultipartFile aadhaar,
            @RequestPart(value = "pan", required = false) MultipartFile pan,
            @RequestPart(value = "resume", required = false) MultipartFile resume,
            @RequestPart(value = "studentResume", required = false) MultipartFile studentResume,
            @RequestPart(value = "certifications", required = false) MultipartFile certifications,
            @RequestPart(value = "companyProfile", required = false) MultipartFile companyProfile,
            @RequestPart(value = "studentIdProof", required = false) MultipartFile studentIdProof,
            @RequestPart(value = "institutionLetter", required = false) MultipartFile institutionLetter,
            @RequestPart(value = "chapterPlan", required = false) MultipartFile chapterPlan) {

        attachUploadedFileNames(profile, photo, aadhaar, pan, resume, studentResume, certifications,
                companyProfile, studentIdProof, institutionLetter, chapterPlan);
        return service.createProfile(profile);
    }

    @Operation(
        summary = "Update Member Profile with uploaded files",
        description = "Updates an existing member profile and stores uploaded files on disk"
    )
    @PutMapping(value = "/{id}/multipart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Profile updateMultipart(
            @Parameter(description = "Member Profile ID", required = true) @PathVariable Long id,
            @RequestPart("profile") Profile profile,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestPart(value = "aadhaar", required = false) MultipartFile aadhaar,
            @RequestPart(value = "pan", required = false) MultipartFile pan,
            @RequestPart(value = "resume", required = false) MultipartFile resume,
            @RequestPart(value = "studentResume", required = false) MultipartFile studentResume,
            @RequestPart(value = "certifications", required = false) MultipartFile certifications,
            @RequestPart(value = "companyProfile", required = false) MultipartFile companyProfile,
            @RequestPart(value = "studentIdProof", required = false) MultipartFile studentIdProof,
            @RequestPart(value = "institutionLetter", required = false) MultipartFile institutionLetter,
            @RequestPart(value = "chapterPlan", required = false) MultipartFile chapterPlan) {

        attachUploadedFileNames(profile, photo, aadhaar, pan, resume, studentResume, certifications,
                companyProfile, studentIdProof, institutionLetter, chapterPlan);
        return service.updateProfile(id, profile);
    }

    private void attachUploadedFileNames(Profile profile, MultipartFile photo, MultipartFile aadhaar,
            MultipartFile pan, MultipartFile resume, MultipartFile studentResume,
            MultipartFile certifications, MultipartFile companyProfile,
            MultipartFile studentIdProof, MultipartFile institutionLetter,
            MultipartFile chapterPlan) {

        if (photo != null && !photo.isEmpty()) {
            profile.setPhotoFileName(saveUploadedFile(photo));
        }
        if (aadhaar != null && !aadhaar.isEmpty()) {
            profile.setAadhaarFileName(saveUploadedFile(aadhaar));
        }
        if (pan != null && !pan.isEmpty()) {
            profile.setPanFileName(saveUploadedFile(pan));
        }
        if (resume != null && !resume.isEmpty()) {
            profile.setResumeFileName(saveUploadedFile(resume));
        }
        if (studentResume != null && !studentResume.isEmpty()) {
            profile.setStudentResumeFileName(saveUploadedFile(studentResume));
        }
        if (certifications != null && !certifications.isEmpty()) {
            profile.setCertificationsFileName(saveUploadedFile(certifications));
        }
        if (companyProfile != null && !companyProfile.isEmpty()) {
            profile.setCompanyProfileFileName(saveUploadedFile(companyProfile));
        }
        if (studentIdProof != null && !studentIdProof.isEmpty()) {
            profile.setStudentIdProofFileName(saveUploadedFile(studentIdProof));
        }
        if (institutionLetter != null && !institutionLetter.isEmpty()) {
            profile.setInstitutionLetterFileName(saveUploadedFile(institutionLetter));
        }
        if (chapterPlan != null && !chapterPlan.isEmpty()) {
            profile.setChapterPlanFileName(saveUploadedFile(chapterPlan));
        }
    }

    private String saveUploadedFile(MultipartFile file) {
        try {
            String cleanName = file.getOriginalFilename() == null
                    ? "upload" + UUID.randomUUID()
                    : file.getOriginalFilename().replaceAll("[^a-zA-Z0-9._-]", "_");
            String savedName = UUID.randomUUID() + "_" + cleanName;

            Path uploadDir = Paths.get("uploads", "profiles").toAbsolutePath().normalize();
            Files.createDirectories(uploadDir);
            Path target = uploadDir.resolve(savedName);
            file.transferTo(target);
            return savedName;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to store uploaded file", e);
        }
    }
    // =========================================================
    // DELETE
    // =========================================================

    @Operation(
        summary = "Delete Profile",
        description = "Deletes an ISTD Profile using its profile Id"
    )
    @DeleteMapping("/{id}")
    public String delete(
            @Parameter(
                description = "Profile Id",
                required = true
            )
            @PathVariable Long id) {

        service.deleteProfile(id);

        return "Profile deleted successfully";
    }
}