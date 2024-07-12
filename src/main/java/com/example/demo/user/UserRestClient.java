package com.example.demo.user;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.http.client.reactive.JdkClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class UserRestClient {
    private final RestClient restClient;

//    you can find RestClient.Builder in the code of RestClient interface, there's a
//    DefaultRestClientBuilder(managed by spring container) that's used in static method RestClient.create()
    public UserRestClient(RestClient.Builder builder) {
//        JdkClientHttpRequestFactory jdkClientHttpRequestFactory = new JdkClientHttpRequestFactory();
//        jdkClientHttpRequestFactory.setReadTimeout(5000);
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/")
//  change HTTP client for customisation or testing, say jdkClientHttpRequestFactory above
//                .requestFactory()
//                set default header
//                .defaultHeader()
//                intercept the request and do stuff to it, @FunctionInterface so can pass a simple lambda
//                or implement the interface ClientHttpRequestInterceptor
//               .requestInterceptor()
                .build();
    }

//    public UserRestClient() {
//        RestClient.create("https://jsonplaceholder.typicode.com/");
//    }
    public List<User> findAll() {
        return restClient.get()
            .uri("/users")
            .retrieve()
            .body(new ParameterizedTypeReference<>() {});
    }

    public User findById(Integer id) {
        return restClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .body(User.class);
    }
}
