package ru.advantum.voicegenerator.processor;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import ru.advantum.voicegenerator.command.FileReaderCommand;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor

@Component
public class ReadAndGen implements CommandLineRunner, ExitCodeGenerator {
    private CommandLine.IFactory factory;
    private FileReaderCommand fileReaderCommand;
    @NonFinal
    private int exitCode;

    @Override
    public void run(String... args) {
        exitCode = new CommandLine(fileReaderCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
