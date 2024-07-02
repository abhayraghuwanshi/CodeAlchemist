package com.odinsolutions.vulcancode_compiler.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.mockito.Mockito.when;

@Tag("Unit")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RunAndCompilerServiceTests {

    @Autowired
    private RunAndCompilerService runAndCompilerService;


     private final String code = "class Solution {\n" +
            "    public int[] buildArray(final int[] nums) {\n" +
            "        final int n = nums.length;\n" +
            "        final int[] ans = new int[n];\n" +
            "\n" +
            "        for(int i = 0; i < n; ++i)\n" +
            "            ans[i] = nums[nums[i]];\n" +
            "\n" +
            "        return ans;\n" +
            "    }\n" +
            "}";

     @AfterEach
    void afterEach() throws IOException {
         Path path = Paths.get("workspace/inputCode.java");
         Files.delete(path);
    }

    @Test
    @DisplayName("Should Create the Java File")
     void test1() throws IOException {
        Path path = Paths.get("workspace/inputCode.java");
        runAndCompilerService.createJavaFile(code);
        assert(Files.exists(path));
    }

    @Test
    @DisplayName("Create and Compile Java file")
    void test2() throws IOException {
        Path path = Paths.get("workspace/inputCode.java");
        runAndCompilerService.createAndCompilerJavaFile(code);
        assert(Files.exists(path));

    }




}
