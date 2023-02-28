package pepMongo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@FieldNameConstants
@Document("pep")
@Data
public class PepData {
    @Id
    private String id;
    @JsonProperty("last_job_title")
    private String lastJobTitle;
    @JsonProperty("first_name_en")
    private String firstNameEn;
    @JsonProperty("type_of_official")
    private String typeOfOfficial;
    @JsonProperty("last_name_en")
    private String lastNameEn;
    @JsonProperty("full_name_en")
    private String fullNameEn;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    @JsonProperty("url")
    private String url;
    @JsonProperty("last_workplace")
    private String lastWorkplace;
    @JsonProperty("related_persons")
    private RelatedPerson[] relatedPersons;
    @JsonProperty("related_companies")
    private RelatedCompany[] relatedCompanies;
    @JsonProperty("is_pep")
    private Boolean isPep;
    @JsonProperty("died")
    private Boolean died;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("declarations")
    private Declaration[] declarations;
    @JsonProperty("wiki_en")
    private String wikiEn;
}

