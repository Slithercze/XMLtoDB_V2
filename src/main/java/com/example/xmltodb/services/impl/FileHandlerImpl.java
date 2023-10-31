package com.example.xmltodb.services.impl;

import com.example.xmltodb.services.FileHandler;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;

@Service
public class FileHandlerImpl implements FileHandler {

    @Override
    public void downloadCities(String fileUrl) {
        try {
            String saveDirectory = "src/main/resources/static";
            URL url = new URL(fileUrl);
            InputStream in = url.openStream();
            File dir = new File(saveDirectory);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File zipFile = new File(dir, "file.zip");
            FileUtils.copyURLToFile(url, zipFile);

            try (ZipArchiveInputStream zipInput = new ZipArchiveInputStream(new BufferedInputStream(new FileInputStream(zipFile)))) {
                ArchiveEntry entry;
                while ((entry = zipInput.getNextEntry()) != null) {
                    if (!zipInput.canReadEntryData(entry)) {
                        continue;
                    }
                    File outputFile = new File(dir, entry.getName());
                    try (OutputStream output = new FileOutputStream(outputFile)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zipInput.read(buffer)) > 0) {
                            output.write(buffer, 0, len);
                        }
                    }
                }
            }

            zipFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
