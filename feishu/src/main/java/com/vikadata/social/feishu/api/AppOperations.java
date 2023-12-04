package com.vikadata.social.feishu.api;

import com.vikadata.social.feishu.model.FeishuAdminUserListResponse;
import com.vikadata.social.feishu.model.FeishuCheckUserAdminRequest;
import com.vikadata.social.feishu.model.FeishuCheckUserAdminResponse;
import com.vikadata.social.feishu.model.FeishuOrderDetailResponse;

/**
 * feishu app operations.
 *
 * @author Shawn Deng
 */
public interface AppOperations {

    FeishuAdminUserListResponse getAppAdminList(String tenantKey);

    FeishuCheckUserAdminResponse checkAppAdmin(String tenantKey,
                                               FeishuCheckUserAdminRequest request);

    FeishuOrderDetailResponse getOrderDetail(String tenantKey, String orderId);

}
