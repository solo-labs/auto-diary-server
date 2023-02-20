package io.solabs.autodiary.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.solabs.autodiary.common.EndPointHelper;
import io.solabs.autodiary.common.EndPointHelperFactory;
import io.solabs.autodiary.dto.RequestDto;
import io.solabs.autodiary.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class OpenAiService {

    private final EndPointHelperFactory endPointHelperFactory;

    @Value("${open-ai.endpoint}")
    private String ENDPOINT;

    @Value("${open-ai.api-key}")
    private String API_KEY;

    @Value("${open-ai.org-key}")
    private String ORG_KEY;

    /**
     * Open AI API 호출
     */
    public ResponseDto execute(RequestDto request) throws Exception {
        try {
            EndPointHelper endPointHelper = endPointHelperFactory.factory();
            ObjectMapper objectMapper = new ObjectMapper();

            HttpUrl httpUrl = Objects.requireNonNull(HttpUrl.parse(ENDPOINT))
                    .newBuilder()
                    .build();

            String requestBodyContent = objectMapper.writeValueAsString(request);

            log.debug("[Request URL] {}", httpUrl);
            log.debug("[Request Body] {}", requestBodyContent);

            okhttp3.Request httpRequest = new okhttp3.Request.Builder()
                    .url(httpUrl)
                    .addHeader("Authorization", String.format("Bearer %s", API_KEY))
                    .addHeader("OpenAI-Organization", ORG_KEY)
                    .post(RequestBody.create(requestBodyContent, okhttp3.MediaType.parse("application/json")))
                    .build();

            okhttp3.Response httpResponse = endPointHelper.execute(httpRequest);

            if (httpResponse.isSuccessful() == false) {
                log.error("Open AI Error: {}", httpResponse.body().string());
                throw new Exception("Open AI Error: " + httpResponse.code() + httpResponse.message());

            } else {
                return objectMapper.readValue(httpResponse.body().string(), new TypeReference<>() {
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
