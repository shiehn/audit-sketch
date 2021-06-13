package handler;

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
    public abstract Output handle(Input input);

    @NonNull
    public Output handleWithAudit(@NonNull Input input, @NonNull AuditParam audit) {
        Output output = this.handle(input);

        this.auditService.audit(audit.value);

        return output;
    }
}
