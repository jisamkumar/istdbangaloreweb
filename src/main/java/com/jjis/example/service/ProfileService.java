package com.jjis.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jjis.example.entity.Profile;
import com.jjis.example.repository.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository repo;

    public ProfileService(ProfileRepository repo) {
        this.repo = repo;
    }

    // =========================================================
    // GET ALL PROFILES
    // =========================================================

    public List<Profile> getAllProfiles() {
        return repo.findAll();
    }

    // =========================================================
    // GET PROFILE BY ID
    // =========================================================

    public Profile getProfileById(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Profile not found with id: " + id));
    }

    // =========================================================
    // CREATE PROFILE
    // =========================================================

    public Profile createProfile(Profile profile) {
        return repo.save(profile);
    }

    // =========================================================
    // UPDATE PROFILE
    // =========================================================

    public Profile updateProfile(Long id, Profile profile) {

        Profile existing = getProfileById(id);

        // -----------------------------------------------------
        // 1. PERSONAL DETAILS
        // -----------------------------------------------------

        if (profile.getMembershipId() != null) {
            existing.setMembershipId(profile.getMembershipId());
        }

        if (profile.getFullName() != null) {
            existing.setFullName(profile.getFullName());
        }

        if (profile.getAddress() != null) {
            existing.setAddress(profile.getAddress());
        }

        if (profile.getEmail() != null) {
            existing.setEmail(profile.getEmail());
        }

        if (profile.getMobile() != null) {
            existing.setMobile(profile.getMobile());
        }

        if (profile.getMemberType() != null) {
            existing.setMemberType(profile.getMemberType());
        }

        if (profile.getIsStudent() != null) {
            existing.setIsStudent(profile.getIsStudent());
        }

        // -----------------------------------------------------
        // 2. STUDENT DETAILS
        // -----------------------------------------------------

        if (profile.getInstitution() != null) {
            existing.setInstitution(profile.getInstitution());
        }

        if (profile.getStudentId() != null) {
            existing.setStudentId(profile.getStudentId());
        }

        if (profile.getCourse() != null) {
            existing.setCourse(profile.getCourse());
        }

        if (profile.getYearOfStudy() != null) {
            existing.setYearOfStudy(profile.getYearOfStudy());
        }

        if (profile.getInstitutionName() != null) {
            existing.setInstitutionName(profile.getInstitutionName());
        }

        if (profile.getInstitutionType() != null) {
            existing.setInstitutionType(profile.getInstitutionType());
        }

        if (profile.getCoordinatorName() != null) {
            existing.setCoordinatorName(profile.getCoordinatorName());
        }

        if (profile.getCoordinatorRole() != null) {
            existing.setCoordinatorRole(profile.getCoordinatorRole());
        }

        if (profile.getCampusLocation() != null) {
            existing.setCampusLocation(profile.getCampusLocation());
        }

        if (profile.getStudentChapterObjective() != null) {
            existing.setStudentChapterObjective(profile.getStudentChapterObjective());
        }

        // -----------------------------------------------------
        // 3. PROFESSIONAL DETAILS
        // -----------------------------------------------------

        if (profile.getDesignation() != null) {
            existing.setDesignation(profile.getDesignation());
        }

        if (profile.getOrganization() != null) {
            existing.setOrganization(profile.getOrganization());
        }

        if (profile.getPreviousOrganizations() != null) {
            existing.setPreviousOrganizations(profile.getPreviousOrganizations());
        }

        if (profile.getTotalExperience() != null) {
            existing.setTotalExperience(profile.getTotalExperience());
        }

        if (profile.getTrainingExperience() != null) {
            existing.setTrainingExperience(profile.getTrainingExperience());
        }

        // -----------------------------------------------------
        // 4. AREA OF EXPERTISE
        // -----------------------------------------------------

        if (profile.getExpertise() != null) {
            existing.setExpertise(profile.getExpertise());
        }

        // -----------------------------------------------------
        // 5. TRAINING DETAILS
        // -----------------------------------------------------

        if (profile.getLanguages() != null) {
            existing.setLanguages(profile.getLanguages());
        }

        if (profile.getDeliveryMode() != null) {
            existing.setDeliveryMode(profile.getDeliveryMode());
        }

        if (profile.getOtherLanguage() != null) {
            existing.setOtherLanguage(profile.getOtherLanguage());
        }

        if (profile.getPreferredLocation() != null) {
            existing.setPreferredLocation(profile.getPreferredLocation());
        }

        // -----------------------------------------------------
        // 6. PREFERRED PROFESSIONAL ROLES
        // -----------------------------------------------------

        if (profile.getPreferredRoles() != null) {
            existing.setPreferredRoles(profile.getPreferredRoles());
        }

        if (profile.getWouldLikeToVolunteer() != null) {
            existing.setWouldLikeToVolunteer(profile.getWouldLikeToVolunteer());
        }

        // -----------------------------------------------------
        // 7. COMPANY / ORGANIZATION REPRESENTATION
        // -----------------------------------------------------

        if (profile.getRepresentsCompany() != null) {
            existing.setRepresentsCompany(
                    profile.getRepresentsCompany());
        }

        if (profile.getCompanyName() != null) {
            existing.setCompanyName(profile.getCompanyName());
        }

        if (profile.getCompanyRole() != null) {
            existing.setCompanyRole(profile.getCompanyRole());
        }

        if (profile.getCompanyAddress() != null) {
            existing.setCompanyAddress(profile.getCompanyAddress());
        }

        if (profile.getEmployees() != null) {
            existing.setEmployees(profile.getEmployees());
        }

        if (profile.getCompanyWebsite() != null) {
            existing.setCompanyWebsite(profile.getCompanyWebsite());
        }

        if (profile.getNatureOfBusiness() != null) {
            existing.setNatureOfBusiness(
                    profile.getNatureOfBusiness());
        }

        if (profile.getOtherBusiness() != null) {
            existing.setOtherBusiness(profile.getOtherBusiness());
        }

        if (profile.getServicesOffered() != null) {
            existing.setServicesOffered(profile.getServicesOffered());
        }

        if (profile.getInterestedCollaborating() != null) {
            existing.setInterestedCollaborating(
                    profile.getInterestedCollaborating());
        }

        if (profile.getCollaborationArea() != null) {
            existing.setCollaborationArea(
                    profile.getCollaborationArea());
        }

        if (profile.getCanProvide() != null) {
            existing.setCanProvide(profile.getCanProvide());
        }

        // -----------------------------------------------------
        // 8. MAJOR CLIENTS
        // -----------------------------------------------------

        if (profile.getMajorClients() != null) {
            existing.setMajorClients(profile.getMajorClients());
        }

        // -----------------------------------------------------
        // 9. UPLOADS
        // -----------------------------------------------------

        if (profile.getPhotoFileName() != null) {
            existing.setPhotoFileName(profile.getPhotoFileName());
        }

        if (profile.getAadhaarFileName() != null) {
            existing.setAadhaarFileName(profile.getAadhaarFileName());
        }

        if (profile.getPanFileName() != null) {
            existing.setPanFileName(profile.getPanFileName());
        }

        if (profile.getResumeFileName() != null) {
            existing.setResumeFileName(profile.getResumeFileName());
        }

        if (profile.getStudentResumeFileName() != null) {
            existing.setStudentResumeFileName(profile.getStudentResumeFileName());
        }

        if (profile.getCertificationsFileName() != null) {
            existing.setCertificationsFileName(
                    profile.getCertificationsFileName());
        }

        if (profile.getCompanyProfileFileName() != null) {
            existing.setCompanyProfileFileName(
                    profile.getCompanyProfileFileName());
        }

        if (profile.getStudentIdProofFileName() != null) {
            existing.setStudentIdProofFileName(profile.getStudentIdProofFileName());
        }

        if (profile.getInstitutionLetterFileName() != null) {
            existing.setInstitutionLetterFileName(profile.getInstitutionLetterFileName());
        }

        if (profile.getChapterPlanFileName() != null) {
            existing.setChapterPlanFileName(profile.getChapterPlanFileName());
        }

        // -----------------------------------------------------
        // 10. DECLARATION
        // -----------------------------------------------------

        if (profile.getDeclaration() != null) {
            existing.setDeclaration(profile.getDeclaration());
        }

        if (profile.getSignature() != null) {
            existing.setSignature(profile.getSignature());
        }

        if (profile.getDate() != null) {
            existing.setDate(profile.getDate());
        }

        // Save updated profile
        return repo.save(existing);
    }

    // =========================================================
    // DELETE PROFILE
    // =========================================================

    public void deleteProfile(Long id) {

        if (!repo.existsById(id)) {
            throw new IllegalArgumentException(
                    "Profile not found with id: " + id);
        }

        repo.deleteById(id);
    }
}