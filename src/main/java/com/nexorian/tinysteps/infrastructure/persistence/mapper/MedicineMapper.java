package com.nexorian.tinysteps.infrastructure.persistence.mapper;
import com.nexorian.tinysteps.application.dto.AgeGroupDTO;
import com.nexorian.tinysteps.application.dto.MedicineDTO;
import com.nexorian.tinysteps.domain.entity.MedicineEntity;

public class MedicineMapper {

    public static MedicineDTO toDTO(MedicineEntity medicine) {
        if (medicine == null) return null;

        AgeGroupDTO ageGroupDTO = medicine.getAgeGroup() != null
            ? AgeGroupMapper.toDTO(medicine.getAgeGroup())
            : null;


        return new MedicineDTO(
            medicine.getId(),
            medicine.getName(),
            medicine.getDescription(),
            medicine.getType(),
            ageGroupDTO
        );
    }
}
