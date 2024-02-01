package com.amaris.amarisconsultingtest.utils.consumer;

import com.amaris.amarisconsultingtest.utils.consumer.responses.ApiResponse;
import com.amaris.amarisconsultingtest.model.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@Getter
public class ApiConsumer {

    @Value("${api.url}")
    private String apiUrl;

    private final RestTemplate apiConsumer;

    @Cacheable("employees")
    public List<Employee> getAllEmployees() throws InterruptedException {
        ApiResponse response = null;
        while (response == null) {

            try {
                log.info("Trying to get data...");
                response = getResponseApi();
            } catch (Exception e) {
                log.error("Se presentó un error al consumir la API");
                Thread.sleep(2000);
            }
        }

        log.info("Data retrieved success");
        return response.getData();
    }


    private ApiResponse getResponseApi() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl + "/employees");

        ResponseEntity<ApiResponse> response = apiConsumer.exchange(
                builder.build(true).encode(StandardCharsets.UTF_8).toUri(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }


}
