package pepMongo.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pepMongo.data.PepData;
import pepMongo.dto.PepDetailsDto;
import pepMongo.dto.PepMostPopularNameDto;
import pepMongo.dto.PepQueryDto;
import pepMongo.repository.PepRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
@RequiredArgsConstructor
public class PepServiceImpl implements PepService {

    @Autowired
    PepRepository pepRepository;

    @Override
    public void saveFile(MultipartFile multipartFile) throws IOException {
        if (!pepRepository.findAll().isEmpty()) {
            pepRepository.deleteAll();
        }
        parseFileToDb(multipartFile);
    }

    private void parseFileToDb(MultipartFile fileToUnzip) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonFactory factory = objectMapper.getFactory();

        try(ZipInputStream zis = new ZipInputStream(fileToUnzip.getInputStream())) {
            ZipEntry entry = zis.getNextEntry();
            if (entry != null) {
                try (JsonParser parser = factory.createParser(zis)) {
                    while (!parser.isClosed()) {
                        JsonToken token = parser.nextToken();
                        if (JsonToken.START_OBJECT.equals(token)) {
                            PepData pepData = objectMapper.readValue(parser, PepData.class);
                            pepRepository.save(pepData);
                        } else {
                            token = parser.nextToken();
                        }
                    }
                }
            }
        }
    }

    @Override
    public List<PepDetailsDto> getPersonByNameSurname(PepQueryDto pepQueryDto) {
        return pepRepository.findByNameSurname(pepQueryDto).stream()
                            .map(this::transformToDetailsDto)
                            .collect(Collectors.toList());
    }

    private PepDetailsDto transformToDetailsDto(PepData pepData) {
        return PepDetailsDto.builder()
                .id(pepData.getId())
                .lastJobTitle(pepData.getLastJobTitle())
                .firstNameEn(pepData.getFirstNameEn())
                .lastNameEn(pepData.getLastNameEn())
                .typeOfOfficial(pepData.getTypeOfOfficial())
                .relatedPersons(pepData.getRelatedPersons())
                .relatedCompanies(pepData.getRelatedCompanies())
                .isPep(pepData.getIsPep())
                .build();
    }

    @Override
    public List<PepMostPopularNameDto> getListOfPopularNamesPep(int limitOfNames) {
        return pepRepository.getListOfPopularNamesPep(limitOfNames);
    }
}
