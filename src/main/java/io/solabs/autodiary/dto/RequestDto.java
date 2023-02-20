package io.solabs.autodiary.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RequestDto {
    private String model; // 사용할 모델, text-davinci-003
    private String prompt; // 문장 내용
    private Integer maxTokens;
    private Double temperature; // 창의도, 0.0 ~ 1.0
}
