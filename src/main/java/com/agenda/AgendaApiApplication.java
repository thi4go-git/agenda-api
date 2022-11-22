package com.agenda;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AgendaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgendaApiApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(
//            @Autowired ContatoServiceImpl service
//    ) {
//        return args -> {
//            System.out.println(service.salvar(new Contato("Thiago", "mail@mail.com",
//                    true)));
//        };
//    }
}
