package com.flex.controller;

import com.flex.util.Constants;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/downloads")
public class FileController {
    /**
     * 指定文件夹路径并创建
     */
    Path path = Paths.get(Constants.FILE_DIR);

    /**
     * Instantiates a new File controller.
     */
    public FileController() {
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Download response entity.
     *
     * @param fileName the file name
     * @return the response entity
     * @throws MalformedURLException the malformed url exception
     */
    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable("fileName") String fileName) throws MalformedURLException {
        Path file = this.path.resolve(fileName);
        System.out.println("============================================================================="+file);
        Resource resource = new UrlResource(file.toUri());
        System.out.println("============================================================================="+resource);
        if (!resource.exists() || !resource.isFile()) {
            throw new NullPointerException("文件不存在");
        }
        if (!resource.isReadable()) {
            throw new NullPointerException("文件错误");
        }
        String contentDisposition = ContentDisposition.builder("attachment")
                .filename(new String(fileName.getBytes(StandardCharsets.UTF_8),
                        StandardCharsets.ISO_8859_1)).build().toString();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                        contentDisposition).contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new FileSystemResource(file));
    }
}
