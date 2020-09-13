package com.mn.newclient;

import com.mn.newclient.model.Clients;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientsTests extends NewclientApplicationTests {

	@Test
	public void testResultCreateClientSuccess() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost/managerClient/save";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		HttpHeaders headers = new HttpHeaders();

		Clients client	= new Clients();
		client.setCpf("23029131831");
		client.setName("Marilia Alves");
		client.setAddress("Rua Teste, 234");

		HttpEntity<Clients> request = new HttpEntity<>(client, headers);

		try {
			restTemplate.postForEntity(uri, request, String.class);

		} catch(HttpClientErrorException e) {
			Assert.assertEquals(500, e.getRawStatusCode());
		}

		Assert.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testCpfInvalidClientSuccess() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost/managerClient/save";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		HttpHeaders headers = new HttpHeaders();

		Clients client	= new Clients();
		client.setCpf("23011131831");
		client.setName("Marilia X Alves");
		client.setAddress("Rua Teste, 234");

		HttpEntity<Clients> request = new HttpEntity<>(client, headers);

		try {
			restTemplate.postForEntity(uri, request, String.class);

		} catch(HttpClientErrorException e) {
			Assert.assertEquals(403, e.getRawStatusCode());
		}

		Assert.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testResultFindCPFSuccess() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost/managerClient/findCpf/23029131831";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assert.assertEquals(true, result.getBody().contains("name"));
	}

	@Test
	public void testResultListAllCPFSuccess() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost/managerClient/listAll";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assert.assertEquals(true, result.getBody().contains("name"));
	}
}