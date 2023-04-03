package com.ala.tp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
		name="film",
		uniqueConstraints=
		@UniqueConstraint(columnNames={"title"})
)
public class film {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String photo;
	private String title;
	private String description;
	private int anneeparution;
	@ManyToOne
	private Categorie categorie;
	@ManyToMany
	private List<acteur> acteurs;

}
