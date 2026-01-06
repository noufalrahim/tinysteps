package com.nexorian.tinysteps.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import org.hibernate.annotations.GenericGenerator;

import com.nexorian.tinysteps.application.dto.AgeGroupDTO;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medicine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String type;

    @ManyToMany 
    @JoinTable(
        name = "medicine_age_group_link", 
        joinColumns = @JoinColumn(name = "medicine_id"),
        inverseJoinColumns = @JoinColumn(name = "age_group_id")
    )   
    private java.util.Set<AgeGroupEntity> ageGroups = new java.util.HashSet<>();
}