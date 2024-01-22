package com.generation.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "tb_postagens")
@Getter
@Setter
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "O Atributo é de preenchimento obrigatório")
	@Size(min = 5, max = 100, message = "O atributo titulo tem no mínimo 5 caracteres e no máximo 100 caracteres")
	private String  titulo;

	@NotBlank(message = "O Atributo é de preenchimento obrigatório")
	@Size(min = 5, max = 100, message = "O atributo titulo tem no mínimo 10 caracteres e no máximo 100 caracteres")
	private String texto;

	@UpdateTimestamp
	private LocalDateTime data;

	@ManyToOne
	@JsonIgnoreProperties("Postagem")
	private Tema tema;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
}


