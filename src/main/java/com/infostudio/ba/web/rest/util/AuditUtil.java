package com.infostudio.ba.web.rest.util;


import com.infostudio.ba.domain.Action;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;

public final class AuditUtil {
    private AuditUtil() {

    }

    public static AuditApplicationEvent createAuditEvent(String employeeId, String entityName, String entityId, Action action ){
        switch (action) {
            case POST:
                return new AuditApplicationEvent(
                        employeeId,
                        "employee",
                        "message=" +  HeaderUtil.createEntityCreationAlert(entityName, entityId)
                );
            case PUT:
                return new AuditApplicationEvent(
                        employeeId,
                        "employee",
                        "message=" +  HeaderUtil.createEntityUpdateAlert(entityName, entityId)
                );
            case DELETE:
                return new AuditApplicationEvent(
                        employeeId,
                        "employee",
                        "message=" +  HeaderUtil.createEntityDeletionAlert(entityName, entityId)
                );
        }
        return null;
    }

}
