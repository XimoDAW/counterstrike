package com.counterstrike.cs.mapper;

import com.counterstrike.cs.domain.entity.Type;
import com.counterstrike.cs.persistance.entity.TypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")

public interface TypeMapper {
    TypeMapper mapper = Mappers.getMapper(TypeMapper.class);
    Type toType (TypeEntity TypeEntity);
    TypeEntity toTypeEntity(Type Type);
}
