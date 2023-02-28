package pepMongo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Jacksonized
@Builder
public class PepMostPopularNameDto {
    private String name;
    private Integer count;
}
