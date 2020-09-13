package com.mn.newclient.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Clients {
    @Id
    private String cpf;

    private String name;

    private String address;

    public Clients() {

    }

    public Clients(String name, String cpf, String address) {
        this.name		= name;
        this.cpf 		= cpf;
        this.address	= address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients client = (Clients) o;
        return cpf == client.cpf &&
                Objects.equals(name, client.name) &&
                Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, name, address);
    }

    public String toString() {
        return "Cliente [nome=" + name + ", cpf=" + cpf + ", endereço=" + address + "]";
    }
}
