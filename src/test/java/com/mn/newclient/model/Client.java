package com.mn.newclient.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = -4042023941980758267L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="cpf")
	private String cpf;

	@Column(name="address")
	private String address;

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
}