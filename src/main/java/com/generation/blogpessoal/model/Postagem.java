package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_postagens")
public class Postagem {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Getter
	@Setter
	@NotBlank(message = "O Atributo é de preenchimento obrigatório")
	@Size(min = 5, max = 100, message = "O atributo titulo tem no mínimo 5 caracteres e no máximo 100 caracteres")
	private String  titulo;
	
	@Getter
	@Setter
	@NotBlank(message = "O Atributo é de preenchimento obrigatório")
	@Size(min = 5, max = 100, message = "O atributo titulo tem no mínimo 10 caracteres e no máximo 100 caracteres")
	private String texto;
	
	@Getter
	@Setter
	@UpdateTimestamp
	private LocalDateTime data;
	
	@Getter
	@Setter
	@ManyToOne
	@JsonIgnoreProperties("Postagem")
	private Tema tema;
}


