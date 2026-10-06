package com.jjis.example.entity;

import jakarta.persistence.*;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "member_profiles")
public class Profile {

    // =========================================================
    // PRIMARY KEY
    // =========================================================

    @Schema(description = "Profile Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // =========================================================
    // 1. PERSONAL DETAILS
    // =========================================================

    @Schema(description = "ISTD Membership Id")
    private String membershipId;

    @Schema(description = "Full Name of the Member")
    @Column(nullable = false)
    private String fullName;

    @Schema(description = "Member Address with Postal Code")
    @Column
    private String address;

    @Schema(description = "Email Id")
    @Column(nullable = false)
    private String email;

    @Schema(description = "Mobile Phone Number")
    @Column(nullable = false)
    private String mobile;

    @Schema(description = "Member type selected in the form")
    private String memberType;

    @Schema(description = "Whether the member is currently a student")
    private String isStudent;


    // =========================================================
    // 2. STUDENT DETAILS
    // =========================================================

    @Schema(description = "Institution / College")
    private String institution;

    @Schema(description = "Student Id / Registration Number")
    private String studentId;

    @Schema(description = "Course / Programme")
    private String course;

    @Schema(description = "Year of Study")
    private String yearOfStudy;

    @Schema(description = "Institution Name for institutional or student chapter profiles")
    private String institutionName;

    @Schema(description = "Institution Type")
    private String institutionType;

    @Schema(description = "Coordinator Name")
    private String coordinatorName;

    @Schema(description = "Coordinator Role")
    private String coordinatorRole;

    @Schema(description = "Campus / City")
    private String campusLocation;

    @Schema(description = "Student Chapter Objective")
    @Column
    private String studentChapterObjective;


    // =========================================================
    // 3. PROFESSIONAL DETAILS
    // =========================================================

    @Schema(description = "Current Designation")
    private String designation;

    @Schema(description = "Name of Organization")
    private String organization;

    @Schema(description = "Previous Organizations")
    private String previousOrganizations;

    @Schema(description = "Total Experience in Years")
    private Integer totalExperience;

    @Schema(description = "Total Training Experience in Years")
    private Integer trainingExperience;


    // =========================================================
    // 4. AREA OF EXPERTISE
    // =========================================================

    @Schema(description = "Area of Expertise")
    @Column
    private String expertise;


    // =========================================================
    // 5. TRAINING DETAILS
    // =========================================================

    @ElementCollection
    @CollectionTable(
        name = "member_languages",
        joinColumns = @JoinColumn(name = "profile_id")
    )
    @MapKeyColumn(name = "language_key")
    @Column(name = "language_value")
    private Map<String, String> languages;

    @ElementCollection
    @CollectionTable(
        name = "member_delivery_mode",
        joinColumns = @JoinColumn(name = "profile_id")
    )
    @MapKeyColumn(name = "delivery_key")
    @Column(name = "delivery_value")
    private Map<String, String> deliveryMode;

    @Schema(description = "Other Language")
    private String otherLanguage;

    @Schema(description = "Preferred Training Location")
    private String preferredLocation;


    // =========================================================
    // 6. PREFERRED PROFESSIONAL ROLES
    // =========================================================

    @ElementCollection
    @CollectionTable(
        name = "member_preferred_roles",
        joinColumns = @JoinColumn(name = "profile_id")
    )
    @MapKeyColumn(name = "role_key")
    @Column(name = "role_value")
    private Map<String, String> preferredRoles;

    @Schema(description = "Whether the member would like to volunteer")
    private String wouldLikeToVolunteer;


    // =========================================================
    // 7. COMPANY / ORGANIZATION REPRESENTATION
    // =========================================================

    @Schema(description = "Whether the member owns, co-owns or represents a company")
    private String representsCompany;

    @Schema(description = "Company Name")
    private String companyName;

    @Schema(description = "Role in the Company")
    private String companyRole;

    @Schema(description = "Company Address with Postal Code")
    @Column
    private String companyAddress;

    @Schema(description = "Number of Employees")
    private Integer employees;

    @Schema(description = "Company Website")
    private String companyWebsite;

    @ElementCollection
    @CollectionTable(
        name = "member_business_nature",
        joinColumns = @JoinColumn(name = "profile_id")
    )
    @MapKeyColumn(name = "business_key")
    @Column(name = "business_value")
    private Map<String, String> natureOfBusiness;

    @Schema(description = "Other Nature of Business")
    private String otherBusiness;

    @Schema(description = "Services Offered")
    @Column
    private String servicesOffered;

    @Schema(description = "Interested in collaborating with ISTD")
    private String interestedCollaborating;

    @Schema(description = "Collaboration Area")
    @Column
    private String collaborationArea;

    @ElementCollection
    @CollectionTable(
        name = "member_can_provide",
        joinColumns = @JoinColumn(name = "profile_id")
    )
    @MapKeyColumn(name = "provide_key")
    @Column(name = "provide_value")
    private Map<String, String> canProvide;


    // =========================================================
    // 8. MAJOR CLIENTS
    // =========================================================

    @Schema(description = "Major Clients on Skill Development")
    @Column
    private String majorClients;


    // =========================================================
    // 9. UPLOADS
    // =========================================================

    @Schema(description = "Passport-size Photograph File Name")
    private String photoFileName;

    @Schema(description = "Aadhaar Copy File Name")
    private String aadhaarFileName;

    @Schema(description = "PAN Copy File Name")
    private String panFileName;

    @Schema(description = "Resume / CV File Name")
    private String resumeFileName;

    @Schema(description = "Student Resume File Name")
    private String studentResumeFileName;

    @Schema(description = "Certifications File Name")
    private String certificationsFileName;

    @Schema(description = "Company Profile File Name")
    private String companyProfileFileName;

    @Schema(description = "Student Id / Enrollment Proof File Name")
    private String studentIdProofFileName;

    @Schema(description = "Institutional Proof File Name")
    private String institutionLetterFileName;

    @Schema(description = "Student Chapter Election Results / Committee Letter File Name")
    private String chapterPlanFileName;


    // =========================================================
    // 10. DECLARATION
    // =========================================================

    @Schema(description = "Member Declaration")
    private Boolean declaration;

    @Schema(description = "Member Signature")
    private String signature;

    @Schema(description = "Date of declaration")
    private String date;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Profile() {
    }


    // =========================================================
    // GETTERS AND SETTERS
    // =========================================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(String isStudent) {
        this.isStudent = isStudent;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(String institutionType) {
        this.institutionType = institutionType;
    }

    public String getCoordinatorName() {
        return coordinatorName;
    }

    public void setCoordinatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    public String getCoordinatorRole() {
        return coordinatorRole;
    }

    public void setCoordinatorRole(String coordinatorRole) {
        this.coordinatorRole = coordinatorRole;
    }

    public String getCampusLocation() {
        return campusLocation;
    }

    public void setCampusLocation(String campusLocation) {
        this.campusLocation = campusLocation;
    }

    public String getStudentChapterObjective() {
        return studentChapterObjective;
    }

    public void setStudentChapterObjective(String studentChapterObjective) {
        this.studentChapterObjective = studentChapterObjective;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPreviousOrganizations() {
        return previousOrganizations;
    }

    public void setPreviousOrganizations(String previousOrganizations) {
        this.previousOrganizations = previousOrganizations;
    }

    public Integer getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Integer totalExperience) {
        this.totalExperience = totalExperience;
    }

    public Integer getTrainingExperience() {
        return trainingExperience;
    }

    public void setTrainingExperience(Integer trainingExperience) {
        this.trainingExperience = trainingExperience;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public Map<String, String> getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(Map<String, String> deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getOtherLanguage() {
        return otherLanguage;
    }

    public void setOtherLanguage(String otherLanguage) {
        this.otherLanguage = otherLanguage;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public Map<String, String> getPreferredRoles() {
        return preferredRoles;
    }

    public void setPreferredRoles(Map<String, String> preferredRoles) {
        this.preferredRoles = preferredRoles;
    }

    public String getWouldLikeToVolunteer() {
        return wouldLikeToVolunteer;
    }

    public void setWouldLikeToVolunteer(String wouldLikeToVolunteer) {
        this.wouldLikeToVolunteer = wouldLikeToVolunteer;
    }

    public String getRepresentsCompany() {
        return representsCompany;
    }

    public void setRepresentsCompany(String representsCompany) {
        this.representsCompany = representsCompany;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyRole() {
        return companyRole;
    }

    public void setCompanyRole(String companyRole) {
        this.companyRole = companyRole;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public Map<String, String> getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(Map<String, String> natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public String getOtherBusiness() {
        return otherBusiness;
    }

    public void setOtherBusiness(String otherBusiness) {
        this.otherBusiness = otherBusiness;
    }

    public String getServicesOffered() {
        return servicesOffered;
    }

    public void setServicesOffered(String servicesOffered) {
        this.servicesOffered = servicesOffered;
    }

    public String getInterestedCollaborating() {
        return interestedCollaborating;
    }

    public void setInterestedCollaborating(String interestedCollaborating) {
        this.interestedCollaborating = interestedCollaborating;
    }

    public String getCollaborationArea() {
        return collaborationArea;
    }

    public void setCollaborationArea(String collaborationArea) {
        this.collaborationArea = collaborationArea;
    }

    public Map<String, String> getCanProvide() {
        return canProvide;
    }

    public void setCanProvide(Map<String, String> canProvide) {
        this.canProvide = canProvide;
    }

    public String getMajorClients() {
        return majorClients;
    }

    public void setMajorClients(String majorClients) {
        this.majorClients = majorClients;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getAadhaarFileName() {
        return aadhaarFileName;
    }

    public void setAadhaarFileName(String aadhaarFileName) {
        this.aadhaarFileName = aadhaarFileName;
    }

    public String getPanFileName() {
        return panFileName;
    }

    public void setPanFileName(String panFileName) {
        this.panFileName = panFileName;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    public String getStudentResumeFileName() {
        return studentResumeFileName;
    }

    public void setStudentResumeFileName(String studentResumeFileName) {
        this.studentResumeFileName = studentResumeFileName;
    }

    public String getCertificationsFileName() {
        return certificationsFileName;
    }

    public void setCertificationsFileName(String certificationsFileName) {
        this.certificationsFileName = certificationsFileName;
    }

    public String getCompanyProfileFileName() {
        return companyProfileFileName;
    }

    public void setCompanyProfileFileName(String companyProfileFileName) {
        this.companyProfileFileName = companyProfileFileName;
    }

    public String getStudentIdProofFileName() {
        return studentIdProofFileName;
    }

    public void setStudentIdProofFileName(String studentIdProofFileName) {
        this.studentIdProofFileName = studentIdProofFileName;
    }

    public String getInstitutionLetterFileName() {
        return institutionLetterFileName;
    }

    public void setInstitutionLetterFileName(String institutionLetterFileName) {
        this.institutionLetterFileName = institutionLetterFileName;
    }

    public String getChapterPlanFileName() {
        return chapterPlanFileName;
    }

    public void setChapterPlanFileName(String chapterPlanFileName) {
        this.chapterPlanFileName = chapterPlanFileName;
    }

    public Boolean getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Boolean declaration) {
        this.declaration = declaration;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}