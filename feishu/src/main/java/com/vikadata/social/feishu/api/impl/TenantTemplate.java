package com.vikadata.social.feishu.api.impl;

import com.vikadata.social.feishu.AbstractFeishuOperations;
import com.vikadata.social.feishu.api.TenantOperations;
import com.vikadata.social.feishu.model.FeishuTenantInfoResponse;

/**
 * tenant template.
 *
 * @author Shawn Deng
 */
public class TenantTemplate extends AbstractFeishuOperations implements TenantOperations {

    private static final String V2_TENANT_QUERY_URL = "/tenant/v2/tenant/query";

    public TenantTemplate(FeishuTemplate feishuTemplate) {
        super(feishuTemplate);
    }

    @Override
    public FeishuTenantInfoResponse getTenantInfo(String tenantKey) {
        return getFeishuTemplate().doGet(buildUri(V2_TENANT_QUERY_URL),
            createAuthHeaders(getFeishuTemplate().getTenantAccessToken(tenantKey, false)),
            FeishuTenantInfoResponse.class);
    }
}
