package com.multi.contactsapp.openapi;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.net.URL;
import java.util.Properties;
import java.util.UUID;

@Service
@Slf4j
public class ApiKeyProcessor {

    private static final String API_KEY_PROPERTIES = "apiKey.properties";
    private static final String MAX_COUNT = "max";

    private static int maxCount = 10;

    private Properties prop;

    @Autowired
    private ApiKeyRepository repository;


    public String requestNewAPIKey(ApiKeyVO apiKeyVO) throws Exception {

        String apiKey = DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes());
        apiKeyVO.setApiKey(apiKey);
        try {
            repository.create(apiKeyVO);
        } catch (Exception e) {
            throw new ApiKeyException("키중복에러");
        }

        return apiKey;
    }

    public void checkApiKey(String hostname, String apiKey) throws ApiKeyException {

        ApiKeyVO readApiKeyVO = repository.read(apiKey);
        if (readApiKeyVO == null) {
            throw new ApiKeyException("등록되지 않은 APIKEY");
        }
        if (hostname == null || readApiKeyVO.getHostName().equals(hostname) == false) {
            throw new ApiKeyException("Origin 불일치");
        }
        if (readApiKeyVO.getCount() > maxCount) {
            throw new ApiKeyException("최대 사용량 초과");
        }

        repository.update(apiKey);

    }

}
