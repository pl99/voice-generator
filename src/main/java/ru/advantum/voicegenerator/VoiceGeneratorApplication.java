package ru.advantum.voicegenerator;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class VoiceGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(VoiceGeneratorApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
