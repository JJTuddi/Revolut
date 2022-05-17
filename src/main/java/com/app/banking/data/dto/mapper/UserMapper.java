package com.app.banking.data.dto.mapper;

import com.app.banking.data.dto.model.UserDto;
import com.app.banking.data.sql.entity.UserEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    UserEntity userDtoToUser(UserDto userDto);

    UserDto userToUserDto(UserEntity user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserDto(UserDto userDto, @MappingTarget UserEntity user);
}
