package pepMongo.service;

//import com.example.Mongo_DB.dto.EmployerInfoDto;
//import com.example.Mongo_DB.dto.EmployerPopularNameDto;
//import com.example.Mongo_DB.dto.EmployerQueryDto;
import org.springframework.web.multipart.MultipartFile;
import pepMongo.dto.PepDetailsDto;
import pepMongo.dto.PepMostPopularNameDto;
import pepMongo.dto.PepQueryDto;

import java.io.IOException;
import java.util.List;


public interface PepService {

    void saveFile(MultipartFile file) throws IOException;

    List<PepDetailsDto> getPersonByNameSurname(PepQueryDto pepQueryDto);

    List<PepMostPopularNameDto> getListOfPopularNamesPep(int limitOfNames);
}

