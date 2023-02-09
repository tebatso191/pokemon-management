package za.co.standardbank.card.util;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import za.co.standardbank.card.dto.response.CommonResponse;
import za.co.standardbank.card.enums.CommonEnum;

@Slf4j
@NoArgsConstructor
public class PokemonUtil {
    public static CommonResponse buildFailedResponse(Exception e) {
        return CommonResponse.builder()
                .success(Boolean.FALSE)
                .message(e.getMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .type(CommonEnum.EXCEPTION.getValue())
                .build();
    }

    public static CommonResponse buildSuccessResponse(Object data) {
        return CommonResponse.builder()
                .success(Boolean.TRUE)
                .message(CommonEnum.SUCCESS.getValue())
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .type(CommonEnum.SUCCESS.getValue())
                .build();
    }
}
