package com.example.io;

import com.example.io.FileReader;
import com.example.io.FileWriter;

public class FileService {
    private FileReader reader;
    private FileWriter writer;

    public FileService(FileReader reader, FileWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String processFile() {
        String content = reader.read();
        writer.write("Processed " + content);
        return "Processed " + content;
    }
}
