package com.mn.newclient.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "clients")
public class Client implements Serializable {

	private static final long serialVersionUID = -4042023941980758267L;

	@Id
	private int id;

	private String name;

	@Indexed(unique = true)
	private String cpf;

	private String address;

	public Client() {

	}

	public Client(String name, String cpf, String address) {
		this.name		= name;
		this.cpf 		= cpf;
		this.address	= address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		Client client = (Client) o;
		return id == client.id &&
				name.equals(client.name) &&
				cpf.equals(client.cpf) &&
				Objects.equals(address, client.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public String toString() {
		return "Cliente [id=" + id + ", nome=" + name + ", cpf=" + cpf + ", endereço=" + address + "]";
	}
}