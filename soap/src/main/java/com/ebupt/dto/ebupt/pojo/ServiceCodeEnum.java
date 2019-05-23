package com.ebupt.dto.ebupt.pojo;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 17:33
 * @Description:
 */
public enum ServiceCodeEnum {
    InnerCall,
    OuterCall,
    RelativeNumbers,
    CloseGroup,
    VideoFallbackInCall,
    ConvergentVPMN,
    DistinctRing,
    CallingLineIdentificationPresentation,
    CallingLineIdentificationRestriction,
    CallingLineIdentificationRestrictionOverride,
    CallWaiting,
    CallHold,
    CallForwardingUnconditional,
    CallForwardingBusy,
    CallForwardingNoReply,
    CallForwardingOffline,
    CallBarring,
    GroupCallerBlackList,
    GroupCallerWhiteList,
    GroupCalleBlackList,
    GroupCalleeWhiteList,
    PersonalCallerBlackList,
    PersonalCallerWhiteList,
    PersonalCalleeBlackList,
    PersonalCalleeWhiteList,
    AlarmCall,
    DoNotDisturb,
    SettingServiceOverstep,
    BlindCallTransfer,
    ConsultativeCallTransfer,
    GroupPickup,
    Designatedpickup,
    Hunting,
    SequentialHuntingGroup,
    PriorityHuntingGroup,
    IdlestHuntingGroup,
    ThreePartyService,
    VirtualAttendantConsole,
    AttendantEnb,
    OneNumber,
    Fax,
    CallContinue,
    ConvenientNumber,
    CTD,
    MagicBox,
    MMTel,
    OneNum,
    Family,
    Home;

    @Override
    public String toString() {
        return "ServiceCodeEnum{}";
    }
}
