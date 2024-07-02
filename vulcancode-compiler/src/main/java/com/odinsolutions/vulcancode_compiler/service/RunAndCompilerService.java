package com.odinsolutions.vulcancode_compiler.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
public class RunAndCompilerService {


    public boolean createAndCompilerJavaFile(String javaCode) throws IOException {
        Path path = createJavaFile(javaCode);
        return compileJavaFile(path);

    }

    public Path createJavaFile(String javaCode) throws IOException {
        Path path = Paths.get("workspace/Solution.java");
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

//    public static boolean compileJavaFile(Path path) {
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        return compiler.run(null, null, null, path.toString()) == 0;
//    }


    public static Object invokeMethod(String className, String methodName, Class<?>[] paramTypes, Object[] params) throws Exception {
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { new URL("file:./workspace/") });
        Class<?> cls = Class.forName(className, true, classLoader);
        Method method = cls.getDeclaredMethod(methodName, paramTypes);
        Object instance = cls.getDeclaredConstructor().newInstance();
        return method.invoke(instance, params);
    }

}
