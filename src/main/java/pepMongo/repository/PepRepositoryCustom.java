package pepMongo.repository;

import pepMongo.data.PepData;
import pepMongo.dto.PepMostPopularNameDto;
import pepMongo.dto.PepQueryDto;

import java.util.List;

public interface PepRepositoryCustom {
    List<PepData> findByNameSurname(PepQueryDto pepQueryDto);
    List<PepMostPopularNameDto> getListOfPopularNamesPep(int limitOfNames);
}
