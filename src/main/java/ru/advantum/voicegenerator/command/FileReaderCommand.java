package ru.advantum.voicegenerator.command;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import ru.advantum.voicegenerator.voicekit.Client;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@CommandLine.Command (name = "readFile")
@Slf4j
public class FileReaderCommand implements Runnable{

    @CommandLine.Option(names = {"--file", "-f"}, required = true)
    String fileName;
    @CommandLine.Option(names = {"--output", "-o"}, defaultValue = "output.wav")
    String outputFileName;

    @CommandLine.Option(names = {"--voice", "-v"}, defaultValue = "maxim")
    String voiceName;


    @Autowired
    Client client;

    @SneakyThrows
    private void readFile(){
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            String fileData = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            log.info("{}", fileData);

            client.streamingSynthesis(fileData, outputFileName, voiceName);

        }
    }

    @Override
    public void run() {
        readFile();
    }
}
