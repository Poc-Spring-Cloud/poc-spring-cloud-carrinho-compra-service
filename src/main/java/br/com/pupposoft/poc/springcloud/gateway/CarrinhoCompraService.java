package br.com.pupposoft.poc.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
public class CarrinhoCompraService {
    public static void main(String[] args) {
        SpringApplication.run(CarrinhoCompraService.class, args);
    }
}
