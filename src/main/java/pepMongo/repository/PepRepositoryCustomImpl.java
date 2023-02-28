package pepMongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import io.micrometer.common.util.StringUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import pepMongo.data.PepData;
import pepMongo.dto.PepMostPopularNameDto;
import pepMongo.dto.PepQueryDto;

import java.util.LinkedList;
import java.util.List;

public class PepRepositoryCustomImpl implements PepRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<PepData> findByNameSurname(PepQueryDto pepQueryDto) {
        Query mongoQuery = new Query();
        if (StringUtils.isNotBlank(pepQueryDto.getName())) {
            mongoQuery.addCriteria(Criteria.where("firstNameEn").regex(pepQueryDto.getName()));
        }
        if (StringUtils.isNotBlank(pepQueryDto.getSurname())) {
            mongoQuery.addCriteria(Criteria.where("lastNameEn").regex(pepQueryDto.getSurname()));
        }
        return mongoTemplate.find(mongoQuery, PepData.class);
    }

    @Override
    public List<PepMostPopularNameDto> getListOfPopularNamesPep(int limitOfNames) {
        MongoCollection<Document> collection = mongoTemplate.getCollection("pep");
        List<Bson> pipeline = List.of(Aggregates.match(Filters.eq("isPep", true)),
                Aggregates.group("firstNameEn", Accumulators.sum("count", 1)),
                Aggregates.sort(Sorts.descending("count")), Aggregates.limit(limitOfNames));
        List<PepMostPopularNameDto> list = new LinkedList<>();
        collection.aggregate(pipeline)
                .forEach(pep -> list.add(PepMostPopularNameDto.builder()
                        .name(pep.getString("_id"))
                        .count(pep.getInteger("count"))
                        .build()));
        return list;
    }


}
