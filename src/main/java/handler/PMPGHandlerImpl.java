package handler;

import exceptions.PMPGException;
import params.InputDTO;
import params.OutputDTO;
import service.AuditService;

public class PMPGHandlerImpl extends PMPGBaseHandler<InputDTO, OutputDTO> {

    public PMPGHandlerImpl(AuditService auditService) {
        super(auditService);
    }

    @Override
    public OutputDTO handle(InputDTO input) throws PMPGException {

        System.out.println("handle called with input");

        OutputDTO output = new OutputDTO();
        output.outputValue = "Input: " + input.inputValue + " has been transformed by the handler";

        return output;
    }

}
