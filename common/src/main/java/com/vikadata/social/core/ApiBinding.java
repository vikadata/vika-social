package com.vikadata.social.core;

import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * common open platform API abstract class
 */
public abstract class ApiBinding {

    private final RestTemplate restTemplate;

    /**
     * constructor
     */
    public ApiBinding() {
        this.restTemplate = createRestTemplateWithDefaultMessageConverters();
    }

    /**
     * config rest template.
     * @return RestTemplate
     */
    protected RestTemplate getRestTemplate() {
        return restTemplate;
    }

    /**
     * set request factory
     * @param requestFactory request factory
     */
    public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
        restTemplate.setRequestFactory(requestFactory);
    }

    private RestTemplate createRestTemplateWithDefaultMessageConverters() {
        RestTemplate client;
        List<HttpMessageConverter<?>> messageConverters = getMessageConverters();
        try {
            client = new RestTemplate(messageConverters);
        } catch (NoSuchMethodError e) {
            client = new RestTemplate();
            client.setMessageConverters(messageConverters);
        }
        client.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        return client;
    }

    /**
     * config message converters
     * @return HttpMessageConverter list
     */
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(getStringHttpMessageConverter());
        messageConverters.add(getFormMessageConverter());
        messageConverters.add(getJsonMessageConverter());
        messageConverters.add(getByteArrayMessageConverter());
        return messageConverters;
    }

    /**
     * config string converter
     * @return StringHttpMessageConverter
     */
    protected StringHttpMessageConverter getStringHttpMessageConverter() {
        return new StringHttpMessageConverter();
    }

    /**
     * config form converter
     * @return FormHttpMessageConverter
     */
    protected FormHttpMessageConverter getFormMessageConverter() {
        FormHttpMessageConverter converter = new FormHttpMessageConverter();
        converter.setCharset(StandardCharsets.UTF_8);
        List<HttpMessageConverter<?>> partConverters = new ArrayList<>();
        partConverters.add(new ByteArrayHttpMessageConverter());
        StringHttpMessageConverter stringHttpMessageConverter =
            new StringHttpMessageConverter(StandardCharsets.UTF_8);
        stringHttpMessageConverter.setWriteAcceptCharset(false);
        partConverters.add(stringHttpMessageConverter);
        partConverters.add(new ResourceHttpMessageConverter());
        converter.setPartConverters(partConverters);
        return converter;
    }

    /**
     * config json converter
     * @return MappingJackson2HttpMessageConverter
     */
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    /**
     * config byte array converter
     * @return ByteArrayHttpMessageConverter
     */
    protected ByteArrayHttpMessageConverter getByteArrayMessageConverter() {
        ByteArrayHttpMessageConverter converter = new ByteArrayHttpMessageConverter();
        converter.setSupportedMediaTypes(
            Arrays.asList(MediaType.IMAGE_JPEG, MediaType.IMAGE_GIF, MediaType.IMAGE_PNG));
        return converter;
    }
}
