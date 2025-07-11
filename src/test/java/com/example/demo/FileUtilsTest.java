package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {
    
    private FileUtils fileUtils;
    
    @TempDir
    Path tempDir;
    
    @BeforeEach
    void setUp() {
        fileUtils = new FileUtils();
    }
    
    @Test
    void testReadWriteString() throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        String content = "Hello, World!";
        
        fileUtils.writeStringToFile(testFile.toString(), content);
        String result = fileUtils.readFileAsString(testFile.toString());
        
        assertEquals(content, result);
    }
    
    @Test
    void testReadFileAsLines() throws IOException {
        Path testFile = tempDir.resolve("lines.txt");
        String content = "Line 1\nLine 2\nLine 3";
        
        Files.writeString(testFile, content);
        List<String> lines = fileUtils.readFileAsLines(testFile.toString());
        
        assertEquals(3, lines.size());
        assertEquals("Line 1", lines.get(0));
        assertEquals("Line 2", lines.get(1));
        assertEquals("Line 3", lines.get(2));
    }
    
    @Test
    void testAppendToFile() throws IOException {
        Path testFile = tempDir.resolve("append.txt");
        
        fileUtils.writeStringToFile(testFile.toString(), "Hello");
        fileUtils.appendToFile(testFile.toString(), " World!");
        
        String result = fileUtils.readFileAsString(testFile.toString());
        assertEquals("Hello World!", result);
    }
    
    @Test
    void testGetFileSize() throws IOException {
        Path testFile = tempDir.resolve("size.txt");
        String content = "12345";
        
        Files.writeString(testFile, content);
        long size = fileUtils.getFileSize(testFile.toString());
        
        assertEquals(5, size);
    }
    
    @Test
    void testDeleteFile() throws IOException {
        Path testFile = tempDir.resolve("delete.txt");
        Files.writeString(testFile, "test");
        
        assertTrue(Files.exists(testFile));
        assertTrue(fileUtils.deleteFile(testFile.toString()));
        assertFalse(Files.exists(testFile));
    }
    
    @Test
    void testCopyFile() throws IOException {
        Path source = tempDir.resolve("source.txt");
        Path destination = tempDir.resolve("destination.txt");
        String content = "Copy me!";
        
        Files.writeString(source, content);
        fileUtils.copyFile(source.toString(), destination.toString());
        
        assertTrue(Files.exists(destination));
        assertEquals(content, Files.readString(destination));
    }
    
    @Test
    void testListFiles() throws IOException {
        Files.createFile(tempDir.resolve("file1.txt"));
        Files.createFile(tempDir.resolve("file2.txt"));
        Files.createDirectory(tempDir.resolve("subdir"));
        
        List<String> files = fileUtils.listFiles(tempDir.toString());
        
        assertEquals(2, files.size());
        assertTrue(files.stream().anyMatch(f -> f.endsWith("file1.txt")));
        assertTrue(files.stream().anyMatch(f -> f.endsWith("file2.txt")));
    }
}