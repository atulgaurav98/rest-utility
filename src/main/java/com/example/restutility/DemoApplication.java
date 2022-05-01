package com.example.restutility;

import com.example.restutility.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Run the SpringBootPagination microservice before running this
 */
@SpringBootApplication
public class DemoApplication {

	@Value(
			"${exchange-rate-url}"
	)
	private String exchangeRateUrl;

	@Autowired
	private RestTemplate restUtilityTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	@Bean
	public void getExchangeRate(){

		// prepare url(can set all query param)
		String url = UriComponentsBuilder.fromHttpUrl(exchangeRateUrl)
				.toUriString();

		// prepare requestType
		HttpMethod requestType= HttpMethod.GET;

		// prepare headers
		HttpHeaders headers = new HttpHeaders();

		//adding to entity
		HttpEntity<ProductResponse> entity = new HttpEntity<>(headers);

		// prepare responseType
		ParameterizedTypeReference<ProductResponse> responseType = new ParameterizedTypeReference<ProductResponse>() {
		};

		//calling restutils template for exchange
		ResponseEntity<ProductResponse> response =restUtilityTemplate.exchange(url,requestType,entity,responseType);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		response.getBody().getData()
				.stream().forEach(dataItem -> {
					System.out.println(dataItem.getId()+"\n"+
							dataItem.getName()+"\n"+
							dataItem.getQuantity()+"\n"+
							dataItem.getPrice()+"\n"+
							"=====================================");
				});
	}

}
