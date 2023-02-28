package pepMongo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@FieldNameConstants
public class PepQueryDto {
    private String name;
    private String surname;
}
