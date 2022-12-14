package com.vikadata.social.dingtalk.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User information --v2 interface returns information
 */
@Setter
@Getter
@ToString
public class DingTalkUserDetail {
    /**
     * The unique identifier of the employee in the current enterprise, also known as the staff Id.
     */
    private String userid;

    /**
     * The unique identifier of the employee within the scope of the current developer's enterprise account,
     * generated by the system, fixed value, and will not change.
     */
    private String unionid;

    /**
     * member name
     */
    private String name;

    /**
     * avatar url
     */
    private String avatar;

    /**
     * 86 Country code Description This parameter is not returned by third-party enterprise applications
     */
    private String stateCode;

    /**
     * The userid of the employee's immediate supervisor.
     */
    private String managerUserid;

    /**
     * Mobile number Description This parameter is not returned by third-party enterprise applications
     */
    private String mobile;

    /**
     * Whether the number is hidden or not Description After the mobile phone number is hidden,
     * the mobile phone number is hidden on the personal information page,
     * but you can still send DING to it and initiate a free business phone call on DingTalk.
     */
    private Boolean hideMobile;

    /**
     * Extension No. Description This parameter is not returned by third-party enterprise applications
     */
    private String telephone;

    /**
     * Employee ID, corresponding to the ID column displayed to the OA background and client profile.
     * The length is 0~64 characters.
     */
    private String jobNumber;

    /**
     * position
     */
    private String title;

    /**
     * Employee's mailbox Description This parameter is not returned by third-party enterprise applications
     */
    private String email;

    /**
     * Office Location. Description This parameter is not returned by third-party enterprise applications
     */
    private String workPlace;

    /**
     * Remark Description. This parameter is not returned by third-party enterprise applications
     */
    private String remark;

    /**
     * Dedicated account login
     */
    private String loginId;

    /**
     * Exclusive account type:
     * sso: an exclusive account created by the company
     * dingtalk: DingTalk creates its own dedicated account
     */
    private String exclusiveAccountType;

    /**
     * Is it a dedicated account
     */
    private Boolean exclusiveAccount;

    /**
     * department id list
     */
    private List<Long> deptIdList;

    /**
     * Sorting of employees in departments
     */
    private List<DeptOrder> deptOrderList;

    /**
     * Extended attribute, maximum length 2000 characters
     */
    private String extension;

    /**
     * entry time, Unix timestamp
     * The entry time will not be returned until the employee basic information in the OA background address book has been maintained.
     * Note ISV applications do not return this parameter
     */
    private Date hiredDate;

    /**
     * Is it activated
     */
    private Boolean active;

    /**
     * Whether real-name authentication has been completed
     */
    private Boolean realAuthed;

    /**
     * Whether you are an executive of the company
     */
    private Boolean senior;

    /**
     * Are you an administrator of the company?
     */
    private Boolean admin;

    /**
     * Are you the boss of the business?
     */
    private Boolean boss;

    /**
     * Whether the employee is a leader in the corresponding department
     */
    private List<DeptLeader> leaderInDept;

    /**
     * role group name
     */
    private List<UserRole> roleList;

    /**
     * Associated information when the user is from an associated organization
     */
    private UnionEmpExt unionEmpExt;

    @Getter
    @Setter
    @ToString

    public static class UserRole {
        /**
         * role id
         */
        private Long id;

        /**
         * Role Name
         */
        private String name;

        /**
         * role group name
         */
        private String groupName;
    }

    @Getter
    @Setter
    @ToString
    public static class DeptOrder {
        /**
         * department id
         */
        private Long deptId;

        /**
         * sorting of employees in departments
         */
        private Long order;
    }

    @Getter
    @Setter
    @ToString
    public static class DeptLeader {
        /**
         * department id
         */
        private Long deptId;

        /**
         * is it a leader
         */
        private Boolean leader;
    }

    @Getter
    @Setter
    @ToString
    public static class UnionEmpExt {
        /**
         * employee's userid
         */
        private String userid;

        /**
         * association mapping
         */
        private List<UnionEmpMapVo> unionEmpMapList;

        /**
         * The enterprise corpid of the organization to which the current user belongs
         */
        private String corpId;
    }

    @Getter
    @Setter
    @ToString
    public static class UnionEmpMapVo {
        /**
         * employee's userid
         */
        private String userid;

        /**
         * The corporate corpid of the associated branch organization.
         */
        private String corpId;
    }

}
