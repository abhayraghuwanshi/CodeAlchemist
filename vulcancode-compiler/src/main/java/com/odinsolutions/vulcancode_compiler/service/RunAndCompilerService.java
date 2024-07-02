package com.odinsolutions.vulcancode_compiler.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
public class RunAndCompilerService {


    public void createAndCompilerJavaFile(String javaCode) throws IOException {
        Path path = createJavaFile(javaCode);
        compileJavaFile(path);

    }

    public Path createJavaFile(String javaCode) throws IOException {
        Path path = Paths.get("workspace/inputCode.java");
        Files.createFile(path);
        if (Files.exists(path)){
            Files.writeString(path, javaCode);
        }
        return path;
    }
    public boolean compileJavaFile(Path path) throws IOException {
        try {
            // Prepare the compile command
            ProcessBuilder processBuilder = new ProcessBuilder("javac", path.toString());
            processBuilder.inheritIO(); // Redirect input and output to current process

            // Start the compilation process
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            // Check if compilation was successful (exit code 0)
            return exitCode == 0;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false; // Compilation failed
        }

    }


}
