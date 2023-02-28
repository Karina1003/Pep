package pepMongo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import pepMongo.data.Declaration;
import pepMongo.data.RelatedCompany;
import pepMongo.data.RelatedPerson;

@Getter
@Builder
@Jacksonized
public class PepDetailsDto {
    private String id;
    private String lastJobTitle;
    private String firstNameEn;
    private String lastNameEn;
    private String typeOfOfficial;
    private RelatedPerson[] relatedPersons;
    private RelatedCompany[] relatedCompanies;
    private Boolean isPep;
}
