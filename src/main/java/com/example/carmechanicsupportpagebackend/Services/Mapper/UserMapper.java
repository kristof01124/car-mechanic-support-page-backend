package com.example.carmechanicsupportpagebackend.Services.Mapper;
import com.example.carmechanicsupportpagebackend.Dtos.UserDAO;
import com.example.carmechanicsupportpagebackend.Models.Car;
import com.example.carmechanicsupportpagebackend.Models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDAO entityToDto(User user);

    Car dtoToEntity(UserDAO userDAO);

}
