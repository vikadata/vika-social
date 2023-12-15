package com.vikadata.social.core;

import org.springframework.web.client.RestTemplate;

/**
 * base operation.
 */
public abstract class AbstractOperations {

    /**
     * rest template.
     */
    protected RestTemplate restTemplate;

    /**
     * constructor.
     *
     * @param restTemplate rest template
     */
    public AbstractOperations(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
