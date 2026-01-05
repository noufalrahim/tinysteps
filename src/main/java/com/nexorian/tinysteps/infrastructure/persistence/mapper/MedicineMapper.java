package com.nexorian.tinysteps.infrastructure.persistence.mapper;
import com.nexorian.tinysteps.application.dto.MedicineDTO;
import com.nexorian.tinysteps.domain.entity.MedicineEntity;

public class MedicineMapper {

    public static MedicineDTO toDTO(MedicineEntity medicine) {
        if (medicine == null) return null;

        return new MedicineDTO(
            medicine.getId(),
            medicine.getName(),
            medicine.getDescription(),
            medicine.getType(),
            medicine.getAgeGroup()
        );
    }
}
