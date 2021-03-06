package com.infostudio.ba.web.rest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infostudio.ba.domain.Action;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;

class AuditMessage {
    private String message;
    private String param;

    public AuditMessage(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

}

public final class AuditUtil {
    private static final String APPLICATION_NAME = "hcmGatewayApp";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private AuditUtil() {
    }

    public static AuditApplicationEvent createAuditEvent(String employeeId, String entityName, String entityId, Action action) {
        AuditMessage auditMessage = createAuditMessage(entityName, entityId, action);
        String jsonMessage = "";
        try {
           jsonMessage = objectMapper.writeValueAsString(auditMessage);
        }catch (JsonProcessingException e) {
            // catch various errors
            e.printStackTrace();
        }

        return new AuditApplicationEvent(
                employeeId,
                "employee",
                "message=" + jsonMessage
        );
    }

    public static AuditMessage createAuditMessage(String entityName, String entityId, Action type) {
        AuditMessage auditMessage = new AuditMessage();
        auditMessage.setParam(entityId);
        switch (type) {
            case POST:
				auditMessage.setMessage(APPLICATION_NAME + "." + entityName + ".created");
                break;
            case PUT:
                auditMessage.setMessage(APPLICATION_NAME + "." + entityName + ".updated");
                break;
            case DELETE:
                auditMessage.setMessage(APPLICATION_NAME + "." + entityName + ".deleted");
                break;
        }

        return auditMessage;

    }

}
