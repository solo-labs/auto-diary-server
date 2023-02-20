package io.solabs.autodiary.service;

import io.solabs.autodiary.dto.RequestDto;
import io.solabs.autodiary.dto.ResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.ObjectUtils;

@SpringBootTest
@ActiveProfiles("local")
class OpenAiServiceTest {

    @Autowired
    OpenAiService openAiService;

    @Test
    void execute() throws Exception {
        String weather = "맑음";
        String mood = "안좋음";
        String activity = "스키타기";
        String withWho = "윤준서";
        String specialThing = "설사를 했다";

        String model = "text-davinci-003";
        String prompt = String.format("아래 단어를 조합해서 일기를 써줘.\n날씨:%s\n기분:%s\n활동:%s\n누구랑:%s\n특별했던 일:%s", weather, mood, activity, withWho, specialThing);
        int maxTokens = 500;
        double temperature = 0.5;

        RequestDto requestDto = new RequestDto(model, prompt, maxTokens, temperature);
        ResponseDto response = openAiService.execute(requestDto);

        System.out.println("\n\n\n[Result]" + response.getChoices().get(0).getText() + "\n\n\n");
        Assertions.assertFalse(ObjectUtils.isEmpty(response.getChoices().get(0).getText()));
    }
}