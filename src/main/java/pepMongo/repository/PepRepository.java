package pepMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pepMongo.data.PepData;

import java.util.List;

@Repository
public interface PepRepository extends MongoRepository<PepData, String>, PepRepositoryCustom {
    @Override
    List<PepData> findAll();

    @Override
    <S extends PepData> S save(S entity);

    @Override
    void deleteAll();
}
