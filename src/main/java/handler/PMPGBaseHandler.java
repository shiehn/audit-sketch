package handler;

import exceptions.PMPGException;
import lombok.NonNull;
import params.AuditParam;
import service.AuditService;

public abstract class PMPGBaseHandler<Input, Output> {

    @NonNull
    private AuditService auditService;

    public PMPGBaseHandler(AuditService auditService) {
        this.auditService = auditService;
    }

    @NonNull
    public abstract Output handle(Input input) throws PMPGException;

    @NonNull
    public Output handleWithAudit(@NonNull Input input, @NonNull AuditParam audit) throws PMPGException {
        Output output = this.handle(input);
        this.auditService.audit(audit.value);
        return output;
    }
}
