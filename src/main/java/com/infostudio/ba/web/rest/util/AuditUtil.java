package com.infostudio.ba.web.rest.util;

import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;

public final class AuditUtil {
    private AuditUtil() {

    }

    public static AuditApplicationEvent createAuditEvent(String employeeId, String message){
        return new AuditApplicationEvent(
         employeeId,
         "employee",
         "message=" + message
        );
    }
}
