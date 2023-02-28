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
public class RelatedPerson {
    @JsonProperty("relationship_type_en")
    private String relationshipTypeEn;
    @JsonProperty("person_en")
    private String personEn;
    @JsonProperty("person_uk")
    private String personUk;
    @JsonProperty("relationship_type")
    private String relationshipType;
}
