package com.poly.api.service;


import com.poly.api.dto.StudentDto;
import com.poly.api.entities.Student;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAll();

    StudentDto findById(int studentId);

    List<StudentDto> findAllByNationId(int nationId);

    List<StudentDto> findAllByProvinceId(int provinceId);

    List<StudentDto> findAllByDistrictId(int districtId);

    List<StudentDto> findAllByTrainingSystemId(int trainingSystem);

    List<StudentDto> findAllByFacilityId(int facilityId);

    List<StudentDto> findAllBySchoolId(int schoolId);

    List<StudentDto> findAllBySpecializedId(int specializedId);

    StudentDto save(StudentDto studentDto);

    List<StudentDto> saveAll(List<StudentDto> studentDtos);

    StudentDto update(StudentDto studentDto);
}
