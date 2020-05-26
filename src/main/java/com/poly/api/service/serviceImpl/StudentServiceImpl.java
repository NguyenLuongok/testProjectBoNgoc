package com.poly.api.service.serviceImpl;

import com.poly.api.dto.*;
import com.poly.api.entities.*;
import com.poly.api.repository.*;
import com.poly.api.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private NationRepository nationRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private TrainingsystemRepository trainingsystemRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SpecializedRepository specializedRepository;


    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepository.findAll();
        return findAllById(students);
    }

    @Override
    public StudentDto findById(int studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentDto studentDto = modelMapper.map(new StudentDto(
                student.getStudentId(),
                student.getName(),
                student.getBirthday(),
                student.getSex(),
                convertNationDtoWithNation(student),
                student.getIdentityId(),
                student.getDateCreate(),
                student.getIssuedBy(),
                convertSchoolDtoWithSchool(student),
                student.getGraduating(),
                student.getGraduatingDate(),
                convertSpecializedDtoWithSpecialized(student),
                convertFacilityDtoWithFacility(student),
                student.getEmail(),
                student.getAddress(),
                student.getPostalAddress(),
                student.getParentsName(),
                student.getParentsPhoneNumberTow(),
                student.getStudentPhoneNumberOne(),
                student.getStudentPhoneNumberTow(),
                student.getParentsPhoneNumberOne(),
                student.getCountry(),
                convertDistrictDtoWithDistrictDto(student),
                convertProvinceDtoWithProvince(student),
                convertTrainingSystemDtoWithTrainingSystem(student),
                student.getFolderId(),
                student.getNameImageCardIdOne(),
                student.getNameImageCardIdTow(),
                student.getNameImageCertificateOfGraduation(),
                student.getNameImageCertificate(),
                student.getNameImagebirthCertificate(),
                student.getNameImageRegistrationForm()
        ), StudentDto.class);
        return studentDto;
    }

    @Override
    public List<StudentDto> findAllByNationId(int nationId) {
        List<Student> students = studentRepository.findAllByNationId(nationId);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllByProvinceId(int provinceId) {
        List<Student> students = studentRepository.findAllByProvinceId(provinceId);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllByDistrictId(int districtId) {
        List<Student> students = studentRepository.findAllByDistrictId(districtId);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllByTrainingSystemId(int trainingSystem) {
        List<Student> students = studentRepository.findAllByTrainingSystemId(trainingSystem);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllByFacilityId(int facilityId) {
        List<Student> students = studentRepository.findAllByFacilityId(facilityId);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllBySchoolId(int schoolId) {
        List<Student> students = studentRepository.findAllBySchoolId(schoolId);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllBySpecializedId(int specializedId) {
        List<Student> students = studentRepository.findAllBySpecializedId(specializedId);
        return findAllById(students);
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        // tao mang chua gia tri chua thanh con trong saveALll
        Student student = convertStudentWithDto(studentDto);
        studentRepository.save(student);
        return studentDto;
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Student student = convertStudentWithDto(studentDto);
        studentRepository.save(student);
        return studentDto;
    }

    public List<StudentDto> findAllById(List<Student> students) {
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add
                    (new StudentDto(
                            student.getStudentId(),
                            student.getName(),
                            student.getBirthday(),
                            student.getSex(),
                            convertNationDtoWithNation(student),
                            student.getIdentityId(),
                                student.getDateCreate(),
                            student.getIssuedBy(),
                            convertSchoolDtoWithSchool(student),
                            student.getGraduating(),
                            student.getGraduatingDate(),
                            convertSpecializedDtoWithSpecialized(student),
                            convertFacilityDtoWithFacility(student),
                            student.getEmail(),
                            student.getAddress(),
                            student.getPostalAddress(),
                            student.getParentsName(),
                            student.getParentsPhoneNumberTow(),
                            student.getStudentPhoneNumberOne(),
                            student.getStudentPhoneNumberTow(),
                            student.getParentsPhoneNumberOne(),
                            student.getCountry(),
                            convertDistrictDtoWithDistrictDto(student),
                            convertProvinceDtoWithProvince(student),
                            convertTrainingSystemDtoWithTrainingSystem(student),
                            student.getFolderId(),
                            student.getNameImageCardIdOne(),
                            student.getNameImageCardIdTow(),
                            student.getNameImageCertificateOfGraduation(),
                            student.getNameImageCertificate(),
                            student.getNameImagebirthCertificate(),
                            student.getNameImageRegistrationForm()));
        }
        Type listType = new TypeToken<List<StudentDto>>() {
        }.getType();
        List<StudentDto> dtoList = modelMapper.map(studentDtos, listType);
        return dtoList;
    }

    public Student convertStudentWithDto(StudentDto studentDto) {
        Student student = null;
        if (studentDto.getNation().getNationId() == 0 || studentDto.getSchool().getSchoolId() == 0 || studentDto.getSpecialized().getSpecializedId() == 0
                || studentDto.getFacility().getFacilityId() == 0 || studentDto.getDistrict().getDistrictId() == 0 || studentDto.getProvince().getProvinceId() == 0
                || studentDto.getTrainingsystem().getTrainingSystemId() == 0) {
            return null;
        } else {
            Nation nation = nationRepository.findById(studentDto.getNation().getNationId()).get();
            School school = schoolRepository.findById(studentDto.getSchool().getSchoolId()).get();
            Specialized specialized = specializedRepository.findById(studentDto.getSpecialized().getSpecializedId()).get();
            Facility facility = facilityRepository.findById(studentDto.getFacility().getFacilityId()).get();
            District district = districtRepository.findById(studentDto.getDistrict().getDistrictId()).get();
            Province province = provinceRepository.findById(studentDto.getProvince().getProvinceId()).get();
            Trainingsystem trainingsystem = trainingsystemRepository.findById(studentDto.getTrainingsystem().getTrainingSystemId()).get();

            student = modelMapper.map(new Student(
                    studentDto.getStudentId(),
                    studentDto.getName(),
                    studentDto.getBirthday(),
                    studentDto.getSex(),
                    nation,
                    studentDto.getIdentityId(),
                    studentDto.getDateCreate(),
                    studentDto.getIssuedBy(),
                    school,
                    studentDto.getGraduating(),
                    studentDto.getGraduatingDate(),
                    specialized,
                    facility,
                    studentDto.getEmail(),
                    studentDto.getAddress(),
                    studentDto.getPostalAddress(),
                    studentDto.getParentsName(),
                    studentDto.getParentsPhoneNumberTow(),
                    studentDto.getStudentPhoneNumberOne(),
                    studentDto.getStudentPhoneNumberTow(),
                    studentDto.getParentsPhoneNumberOne(),
                    studentDto.getCountry(),
                    district,
                    province,
                    trainingsystem,
                    studentDto.getFolderId(),
                    studentDto.getNameImageCardIdOne(),
                    studentDto.getNameImageCardIdTow(),
                    studentDto.getNameImageCertificateOfGraduation(),
                    studentDto.getNameImageCertificate(),
                    studentDto.getNameImagebirthCertificate(),
                    studentDto.getNameImageRegistrationForm()
            ), Student.class);
        }
        return student;
    }

    @Override
    public List<StudentDto> saveAll(List<StudentDto> studentDtos) {
        List<StudentDto> dtoList = new ArrayList<>();
        if (studentDtos != null) {
            for (StudentDto studentDto : studentDtos) {
                Student student = convertStudentWithDto(studentDto);
                if (student != null) {
                    dtoList.add(studentDto);
                    studentRepository.save(student);
                }
            }
        }
        return dtoList;
    }

    public NationDto convertNationDtoWithNation(Student student) {
        Nation nation = nationRepository.findById(student.getNation().getNationId()).get();
        NationDto nationDto = modelMapper.map(new NationDto(nation.getNationId(), nation.getNationName()), NationDto.class);
        return nationDto;
    }

    public SchoolDto convertSchoolDtoWithSchool(Student student) {
        School school = schoolRepository.findById(student.getSchool().getSchoolId()).get();
        SchoolDto schoolDto = modelMapper.map(new SchoolDto(school.getSchoolId(),school.getSchoolName()),SchoolDto.class);
        return schoolDto;
    }

    public SpecializedDto convertSpecializedDtoWithSpecialized(Student student) {
        Specialized specialized = specializedRepository.findById(student.getSpecialized().getSpecializedId()).get();
        SpecializedDto specializedDto = modelMapper.map(new SpecializedDto(specialized.getSpecializedId(),specialized.getSpecializedName()),SpecializedDto.class);
        return specializedDto;
    }

    public FacilityDto convertFacilityDtoWithFacility(Student student){
        Facility facility = facilityRepository.findById(student.getFacility().getFacilityId()).get();
        FacilityDto facilityDtos = modelMapper.map(new FacilityDto(facility.getFacilityId(),facility.getFacilityName()),FacilityDto.class);
        return facilityDtos;
    }

    public DistrictDto convertDistrictDtoWithDistrictDto(Student student) {
        District district = districtRepository.findById(student.getDistrict().getDistrictId()).get();
        DistrictDto districtDto = modelMapper.map(new DistrictDto(district.getDistrictId(),district.getDistrictName(),district.getProvince().getProvinceId()),DistrictDto.class);
        return districtDto;
    }

    public ProvinceDto convertProvinceDtoWithProvince(Student student) {
        Province province = provinceRepository.findById(student.getProvince().getProvinceId()).get();
        ProvinceDto provinceDto = modelMapper.map(new ProvinceDto(province.getProvinceId(),province.getProvinceName()),ProvinceDto.class);
        return provinceDto;
    }

    public TrainingsystemDto convertTrainingSystemDtoWithTrainingSystem(Student student){
        Trainingsystem trainingsystem = trainingsystemRepository.findById(student.getTrainingsystem().getTrainingSystemId()).get();
        TrainingsystemDto trainingsystemDto = modelMapper.map(new TrainingsystemDto(trainingsystem.getTrainingSystemId(),trainingsystem.getTrainingSystemName()),TrainingsystemDto.class);
        return trainingsystemDto;
    }
}
