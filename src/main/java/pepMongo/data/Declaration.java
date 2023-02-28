package pepMongo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Declaration {
    @JsonProperty("position_en")
    private String positionEn;
    @JsonProperty("url")
    private String url;
    @JsonProperty("region_uk")
    private String regionUk;
    @JsonProperty("office_en")
    private String officeEn;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("region_en")
    private String regionEn;
}

