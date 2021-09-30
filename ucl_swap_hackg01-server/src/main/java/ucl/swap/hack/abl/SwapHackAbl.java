package ucl.swap.hack.abl;

import javax.inject.Inject;
import org.springframework.stereotype.Component;
import uu.app.exception.AppErrorMap;
import uu.app.validation.ValidationResult;
import uu.app.validation.Validator;
import uu.app.validation.utils.ValidationResultUtils;
import uu.app.workspace.api.Profile;
import ucl.swap.hack.dao.SwapHackDao;
import ucl.swap.hack.api.dto.SwapHackInitDtoIn;
import ucl.swap.hack.api.dto.SwapHackInitDtoOut;
import ucl.swap.hack.api.exceptions.SwapHackInitRuntimeException;
import ucl.swap.hack.api.exceptions.SwapHackInitRuntimeException.Error;

@Component
public final class SwapHackAbl {

  private static final String AUTHORITIES_CODE = "Authorities";

  @Inject
  private Validator validator;

  @Inject
  private Profile profile;

  @Inject
  private SwapHackDao swapHackDao;

  public SwapHackInitDtoOut init(String awid, SwapHackInitDtoIn dtoIn) {
    // HDS 1
    ValidationResult validationResult = validator.validate(dtoIn);
    if (!validationResult.isValid()) {
      // A1
      throw new SwapHackInitRuntimeException(Error.INVALID_DTO_IN, ValidationResultUtils.validationResultToAppErrorMap(validationResult));
    }

    // HDS 2
    profile.set(awid, AUTHORITIES_CODE, dtoIn.getUuAppProfileAuthorities());

    // HDS 3 - HDS N
    // TODO Implement according to application needs...

    // HDS N+1
    SwapHackInitDtoOut swapHackInitDtoOut = new SwapHackInitDtoOut();
    swapHackInitDtoOut.setUuAppErrorMap(new AppErrorMap());
    return swapHackInitDtoOut;
  }

}
