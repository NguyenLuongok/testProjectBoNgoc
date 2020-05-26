package com.poly.api.service.serviceImpl;


import com.poly.api.dto.FacilityDto;
import com.poly.api.dto.UserDto;
import com.poly.api.entities.Facility;
import com.poly.api.entities.User;
import com.poly.api.repository.FacilityRepository;
import com.poly.api.repository.UserRepository;
import com.poly.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users){
            Facility facility = facilityRepository.findById(user.getFacility().getFacilityId()).get();
            userDtos.add(new UserDto(user.getUserId(),user.getUsername(),user.getEmail(),user.getPassword(),user.getAddress(),user.getPhoneNumber(),convertFacilityDtoWithFacility(user)));
        }
        Type listType = new TypeToken<List<UserDto>>(){}.getType();
        List<UserDto> userDtoList = modelMapper.map(userDtos,listType);
        return userDtoList;
    }

    @Override
    public UserDto findById(int id) {
        User user = userRepository.findById(id).get();
        UserDto userDto = modelMapper.map(new UserDto(user.getUserId(),user.getUsername(),user.getEmail(),user.getPassword(),user.getAddress(),
                user.getPhoneNumber(),convertFacilityDtoWithFacility(user)),UserDto.class);
        return userDto;
    }

    @Override
    public UserDto save(UserDto userDto) {
        Facility facility = facilityRepository.findById(userDto.getFacility().getFacilityId()).get();
        System.out.println(facility.getFacilityId());
        if(facility != null){
            User user = modelMapper.map(new User(userDto.getUsername(),userDto.getEmail(),userDto.getPassword(),userDto.getAddress(),userDto.getPhoneNumber(),facility),User.class);
            userRepository.save(user);
        }
        return userDto;
    }
    

    @Override
    public UserDto update(UserDto userDto) {
        Facility facility = facilityRepository.findById(userDto.getFacility().getFacilityId()).get();
        User user = modelMapper.map(new User(userDto.getUserId(),userDto.getUsername(),userDto.getEmail(),userDto.getPassword(),userDto.getAddress(),userDto.getPhoneNumber(),facility),User.class);
        userRepository.save(user);
        return userDto;
    }

    public FacilityDto convertFacilityDtoWithFacility(User user){
        Facility facility = facilityRepository.findById(user.getFacility().getFacilityId()).get();
        FacilityDto facilityDtos = modelMapper.map(new FacilityDto(facility.getFacilityId(),facility.getFacilityName()),FacilityDto.class);
        return facilityDtos;
    }
}
