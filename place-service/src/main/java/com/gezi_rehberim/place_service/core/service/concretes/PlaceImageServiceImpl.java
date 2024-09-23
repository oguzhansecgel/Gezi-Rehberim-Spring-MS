package com.gezi_rehberim.place_service.core.service.concretes;

import com.gezi_rehberim.place_service.core.exception.place.PlaceNotFoundException;
import com.gezi_rehberim.place_service.core.exception.placeimage.PlaceImageEmptyFileException;
import com.gezi_rehberim.place_service.core.message.PlaceImageMessage;
import com.gezi_rehberim.place_service.core.service.abstracts.PlaceImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceImageServiceImpl implements PlaceImageService {


    public List<String> savePlaceImages(List<MultipartFile> imageFiles) {
        List<String> imageUrls = new ArrayList<>();

        for (MultipartFile imageFile : imageFiles) {
            String originalFilename = imageFile.getOriginalFilename();
            if (originalFilename == null || originalFilename.isEmpty()) {
                throw new PlaceImageEmptyFileException(PlaceImageMessage.PLACE_IMAGE_EMPTY_FILE);
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");
            String timestamp = LocalDateTime.now().format(formatter);
            String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
            String filename = timestamp + extension;

            try {
                String uploadDir = "place-service/uploads/";
                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdir();
                }
                Path filePath = Paths.get(uploadDir + filename);
                Files.write(filePath, imageFile.getBytes());

                imageUrls.add(filePath.toString());

            } catch (IOException e) {
                throw new PlaceNotFoundException(PlaceImageMessage.PLACE_IMAGE_NOT_FOUNT);
            }
        }

        return imageUrls;
    }

    @Override
    public void deletedImage(List<String> imageUrls) {
        for (String filePath : imageUrls) {
            Path path = Paths.get(filePath);
            try {
                Files.deleteIfExists(path);
            } catch (IOException e) {
                throw new PlaceImageEmptyFileException(PlaceImageMessage.PLACE_IMAGE_NOT_FOUND_FILE);
            }
        }
    }


}
