package ru.advantum.voicegenerator.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.advantum.voicegenerator.voicekit.Client;

@Configuration
@ConfigurationProperties(prefix = "tinkoff")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ClientVoiceKitApiConfig {
    String voicekitApiKey;
    String voicekitSecretKey;

    @Bean
    public Client client() {

        return new Client(voicekitApiKey, voicekitSecretKey);
    }
}
