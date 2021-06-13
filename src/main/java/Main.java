import handler.PMPGHandlerImpl;
import params.AuditParam;
import params.InputDTO;
import params.OutputDTO;
import service.AuditService;

public class Main {

    //PRETEND THIS IS A CONTROLLER
    public static void main(String[] args) {
        //SETUP DEPS
        AuditService auditService = new AuditService();
        PMPGHandlerImpl pmpgBaseHandler = new PMPGHandlerImpl(auditService);

        //CALL THE HANDLER WITH THE INPUT DTO & AUDIT OBJECT
        OutputDTO output = pmpgBaseHandler
                .handleWithAudit(InputDTO.builder().inputValue("my input value").build(),
                        AuditParam.builder().value("AUDIT THIS EVENT").build());

        //RETURN THE DTO
        System.out.println("RESULT: " + output.outputValue);
    }
}
