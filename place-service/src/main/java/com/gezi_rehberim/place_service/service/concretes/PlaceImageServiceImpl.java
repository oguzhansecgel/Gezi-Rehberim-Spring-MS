package com.gezi_rehberim.place_service.service.concretes;

import com.gezi_rehberim.place_service.core.exception.place.PlaceNotFoundException;
import com.gezi_rehberim.place_service.core.exception.placeimage.PlaceImageEmptyFileException;
import com.gezi_rehberim.place_service.core.message.PlaceImageMessage;
import com.gezi_rehberim.place_service.dto.request.placeimage.CreatePlaceImageRequest;
import com.gezi_rehberim.place_service.dto.response.placeimage.CreatePlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetAllPlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetByIdPlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetByPlaceImageWithPlaceResponse;
import com.gezi_rehberim.place_service.mapper.PlaceImageMapping;
import com.gezi_rehberim.place_service.model.PlaceImage;
import com.gezi_rehberim.place_service.repositories.PlaceImageRepository;
import com.gezi_rehberim.place_service.service.abstracts.PlaceImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceImageServiceImpl implements PlaceImageService {


    private final PlaceImageRepository placeImageRepository;

    public PlaceImageServiceImpl(PlaceImageRepository placeImageRepository) {
        this.placeImageRepository = placeImageRepository;
    }

    @Override
    public CreatePlaceImageResponse createPlaceImage(CreatePlaceImageRequest request) {
        MultipartFile imageFile = request.getImageFile();
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


            PlaceImage placeImage = PlaceImageMapping.INSTANCE.createPlaceImage(request);
            placeImage.setImageUrl(filePath.toString());
            PlaceImage savedImage = placeImageRepository.save(placeImage);

            return new CreatePlaceImageResponse(savedImage.getId(),savedImage.getImageUrl(), savedImage.getPlace().getId());

        } catch (IOException e) {
            throw new PlaceNotFoundException(PlaceImageMessage.PLACE_IMAGE_NOT_FOUNT);
        }
    }

    @Override
    public void deletedImage(int placeImageId) {
        PlaceImage placeImage = placeImageRepository.findById(placeImageId).orElseThrow(()-> new PlaceNotFoundException(PlaceImageMessage.PLACE_IMAGE_NOT_FOUNT));

        String filePath = placeImage.getImageUrl();
        Path path = Paths.get(filePath);

        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new PlaceImageEmptyFileException(PlaceImageMessage.PLACE_IMAGE_NOT_FOUND_FILE);
        }

        placeImageRepository.deleteById(placeImageId);
    }

    @Override
    public List<GetByPlaceImageWithPlaceResponse> getPlaceImageWithPlace(int placeId) {
        List<PlaceImage> placeImage = placeImageRepository.findByPlaceId(placeId);
        return PlaceImageMapping.INSTANCE.listByPlaceImageWithPlaceResponse(placeImage);
    }

    @Override
    public List<GetAllPlaceImageResponse> getAllPlaceImage() {
        List<PlaceImage> placeImages = placeImageRepository.findAll();
        return PlaceImageMapping.INSTANCE.placeToListPlaceImageResponse(placeImages);
    }

    @Override
    public Optional<GetByIdPlaceImageResponse> getPlaceImageById(int placeImageId) {
        Optional<PlaceImage> placeImage = placeImageRepository.findById(placeImageId);
        if (placeImage.isEmpty())
        {
            throw new PlaceNotFoundException(PlaceImageMessage.PLACE_IMAGE_NOT_FOUNT);
        }
        return placeImage.map(PlaceImageMapping.INSTANCE::getByIdPlaceImage);
    }
}
