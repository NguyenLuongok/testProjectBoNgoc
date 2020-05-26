package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class StudentDto {
    private int studentId;
    private String name;
    private String birthday;
    private Boolean sex;
    //
    private NationDto nation;
    //
    private Integer identityId;
    private String dateCreate;
    private String issuedBy;
    //
    private SchoolDto school;
    //

    private String graduating;
    private String graduatingDate;
    //
    private SpecializedDto specialized;
    //
    //
    private FacilityDto facility;
    //
    private String email;
    private String address;
    private String postalAddress;
    private String parentsName;
    private String parentsPhoneNumberTow;
    private String studentPhoneNumberOne;
    private String studentPhoneNumberTow;
    private String parentsPhoneNumberOne;
    private String country;
    //
    private DistrictDto district;
    //
    //
    private ProvinceDto province;
    //
    //
    private TrainingsystemDto trainingsystem;
    //

    private Integer folderId;
    private String nameImageCardIdOne;
    private String nameImageCardIdTow;
    private String nameImageCertificateOfGraduation;
    private String nameImageCertificate;
    private String nameImagebirthCertificate;
    private String nameImageRegistrationForm;

    public StudentDto() {
    }

//    public StudentDto(int studentId, String name, String birthday, Boolean sex, int nationId, Integer identityId, String dateCreate, String issuedBy, int schoolId, String graduating, String graduatingDate, int specializedId, int facilityId, String email, String address, String postalAddress, String parentsName, String parentsPhoneNumberTow, String studentPhoneNumberOne, String studentPhoneNumberTow, String parentsPhoneNumberOne, String country, int districtId, int provinceId, int trainingsystemId, Integer folderId, String nameImageCardIdOne, String nameImageCardIdTow, String nameImageCertificateOfGraduation, String nameImageCertificate, String nameImagebirthCertificate, String nameImageRegistrationForm) {
//        this.studentId = studentId;
//        this.name = name;
//        this.birthday = birthday;
//        this.sex = sex;
//        this.nationId = nationId;
//        this.identityId = identityId;
//        this.dateCreate = dateCreate;
//        this.issuedBy = issuedBy;
//        this.schoolId = schoolId;
//        this.graduating = graduating;
//        this.graduatingDate = graduatingDate;
//        this.specializedId = specializedId;
//        this.facilityId = facilityId;
//        this.email = email;
//        this.address = address;
//        this.postalAddress = postalAddress;
//        this.parentsName = parentsName;
//        this.parentsPhoneNumberTow = parentsPhoneNumberTow;
//        this.studentPhoneNumberOne = studentPhoneNumberOne;
//        this.studentPhoneNumberTow = studentPhoneNumberTow;
//        this.parentsPhoneNumberOne = parentsPhoneNumberOne;
//        this.country = country;
//        this.districtId = districtId;
//        this.provinceId = provinceId;
//        this.trainingsystemId = trainingsystemId;
//        this.folderId = folderId;
//        this.nameImageCardIdOne = nameImageCardIdOne;
//        this.nameImageCardIdTow = nameImageCardIdTow;
//        this.nameImageCertificateOfGraduation = nameImageCertificateOfGraduation;
//        this.nameImageCertificate = nameImageCertificate;
//        this.nameImagebirthCertificate = nameImagebirthCertificate;
//        this.nameImageRegistrationForm = nameImageRegistrationForm;
//    }

    public StudentDto(int studentId, String name, String birthday, Boolean sex, NationDto nation, Integer identityId, String dateCreate, String issuedBy, SchoolDto school, String graduating, String graduatingDate, SpecializedDto specialized, FacilityDto facility, String email, String address, String postalAddress, String parentsName, String parentsPhoneNumberTow, String studentPhoneNumberOne, String studentPhoneNumberTow, String parentsPhoneNumberOne, String country, DistrictDto district, ProvinceDto province, TrainingsystemDto trainingsystem, Integer folderId, String nameImageCardIdOne, String nameImageCardIdTow, String nameImageCertificateOfGraduation, String nameImageCertificate, String nameImagebirthCertificate, String nameImageRegistrationForm) {
        this.studentId = studentId;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.nation = nation;
        this.identityId = identityId;
        this.dateCreate = dateCreate;
        this.issuedBy = issuedBy;
        this.school = school;
        this.graduating = graduating;
        this.graduatingDate = graduatingDate;
        this.specialized = specialized;
        this.facility = facility;
        this.email = email;
        this.address = address;
        this.postalAddress = postalAddress;
        this.parentsName = parentsName;
        this.parentsPhoneNumberTow = parentsPhoneNumberTow;
        this.studentPhoneNumberOne = studentPhoneNumberOne;
        this.studentPhoneNumberTow = studentPhoneNumberTow;
        this.parentsPhoneNumberOne = parentsPhoneNumberOne;
        this.country = country;
        this.district = district;
        this.province = province;
        this.trainingsystem = trainingsystem;
        this.folderId = folderId;
        this.nameImageCardIdOne = nameImageCardIdOne;
        this.nameImageCardIdTow = nameImageCardIdTow;
        this.nameImageCertificateOfGraduation = nameImageCertificateOfGraduation;
        this.nameImageCertificate = nameImageCertificate;
        this.nameImagebirthCertificate = nameImagebirthCertificate;
        this.nameImageRegistrationForm = nameImageRegistrationForm;
    }
}
