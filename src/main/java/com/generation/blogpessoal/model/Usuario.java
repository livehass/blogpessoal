package com.generation.blogpessoal.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O atributo nome é obrigatório")
    private String nome;

    @NotNull(message = "O atributo usuário é obrigatório")
    @Email(message = "O atributo usuário deve ser um e-mail válido")
    private String usuario;

    @NotBlank(message = "O atributo senha é obrigatório")
    @Size(min = 8, message = "O atributo senha deve ter no mínimo 8 caracteres ")
    private String senha;

    @Size(max=5000, message = "O atributo foto não pode ser maior quuue 5000 caracteres")
    private String foto;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Postagem> postagem;

}


