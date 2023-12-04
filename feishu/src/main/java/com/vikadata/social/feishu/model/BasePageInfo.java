package com.vikadata.social.feishu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Base page info.
 *
 * @author Shawn Deng
 */
@Setter
@Getter
@ToString
public class BasePageInfo {

    @JsonProperty("has_more")
    private boolean hasMore;

    private String pageToken;
}
