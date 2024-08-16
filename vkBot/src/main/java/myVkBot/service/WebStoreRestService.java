package myVkBot.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import myVkBot.Client.WebStoreResponse;
import myVkBot.model.Product;
import myVkBot.repository.ProductRepository;
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

    private DiscoveryClient discoveryClient;

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
        List<WebStoreResponse> projects = null;
        int attempts = 5;
        while (attempts-- > 0) {
            try {
                projects = restClient().get()
                        .uri("/api/projects")
                        .retrieve()
                        .body(new ParameterizedTypeReference<>() {
                        });
                break;
            } catch (HttpServerErrorException e) {
                // ignore
            }
        }
        if (projects == null) {
            throw new RuntimeException("oops");
        }
        return projects;
    }

}
