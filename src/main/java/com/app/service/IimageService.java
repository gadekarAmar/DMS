package com.app.service;import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IimageService {
    String upLoadImage(String path ,MultipartFile file) throws IOException;

}
