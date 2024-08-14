package myVkBot.service;

import myVkBot.Client.WebStoreResponse;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class WebStoreRestService {

    private final DiscoveryClient discoveryClient;

    public WebStoreRestService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    private RestClient restClient() {
        List<ServiceInstance> instances = discoveryClient.getInstances("WEB-STORE");
        int instancesCount = instances.size();
        int instanceIndex = ThreadLocalRandom.current().nextInt(0, instancesCount);

        ServiceInstance instance = instances.get(instanceIndex);
        String uri = "http://" + instance.getHost() + ":" + instance.getPort();
        System.out.println("URI = " + uri);
        return RestClient.create(uri);
    }

    public List<WebStoreResponse> findAll() {
        List<WebStoreResponse> responses = null;
        int attempts = 5;
        while (attempts-- > 0) {
            try {
                responses = restClient().get()
                        .uri("/api/products")
                        .retrieve()
                        .body(new ParameterizedTypeReference<List<WebStoreResponse>>() {
                        });
                break;
            } catch (HttpServerErrorException e) {
                // ignore
            }
        }
        if (responses == null) {
            throw new RuntimeException("oops");
        } else {
            return responses;
        }
    }

}
