package com.mn.newclient.controller;

import com.mn.newclient.model.Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Cadastro de clientes", description = "Estudo springboot ")
public class ClientRestController {


	@ApiOperation(value = "Cadastro de novos clientes")
	@PostMapping("/newClient")
	public ResponseEntity<String> simian(@RequestBody Client client) {

		try {
			// Validação docpf
			this.isValidCpf(client.getCpf());

			//Service.save(client);

		}catch (Exception e){
			return new ResponseEntity<>("HTTP 403-FORBIDDEN", HttpStatus.FORBIDDEN);
		}

		/*
		if(  )
			return new ResponseEntity<>("HTTP 200-OK", HttpStatus.OK);
		else
			return new ResponseEntity<>("HTTP 403-FORBIDDEN", HttpStatus.FORBIDDEN);

		 */
	}

	// Validação do cpf do cliente
	public void isValidCpf(String cpf) throws Exception{
		throw new Exception();
	}

}
