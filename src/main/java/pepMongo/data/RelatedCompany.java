package pepMongo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@FieldNameConstants
@Data
public class RelatedCompany {
    private String id;
    @JsonProperty("relationship_type_en")
    private String relationshipTypeEn;
    @JsonProperty("to_company_short_en")
    private String toCompanyShortEn;
    @JsonProperty("to_company_uk")
    private String toCompanyUk;
    @JsonProperty("to_company_is_state")
    private Boolean toCompanyIsState;
}

