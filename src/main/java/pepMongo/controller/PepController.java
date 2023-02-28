package pepMongo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pepMongo.dto.PepDetailsDto;
import pepMongo.dto.PepMostPopularNameDto;
import pepMongo.dto.PepQueryDto;
import pepMongo.service.PepService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pep")
@RequiredArgsConstructor
public class PepController {

    private final PepService pepService;

    @PostMapping("/upload")
    public ResponseEntity submit(@RequestParam MultipartFile file) {
        try {
            pepService.saveFile(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to download file");
        }
        return ResponseEntity.ok("Downloaded successfully");
    }

    @GetMapping("/getPep")
    public List<PepDetailsDto> getPep(@RequestBody PepQueryDto pepQueryDto) {
        return pepService.getPersonByNameSurname(pepQueryDto);
    }

    @GetMapping("/getMostPopularNames")
    public List<PepMostPopularNameDto> getListPopularPerson() {
        return pepService.getListOfPopularNamesPep(10);
    }
}

