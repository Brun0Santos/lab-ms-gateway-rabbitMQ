package io.github.bruno.msclientservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String name;
    private String age;

    public ClientEntity() {
    }

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
