package com.ala.tp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Categorie {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	@JsonIgnore
	@OneToMany(mappedBy = "categorie",cascade = CascadeType.ALL)
	List<film> films;
	
}
