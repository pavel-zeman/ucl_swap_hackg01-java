package ucl.swap.hack.api.dto;

import uu.app.dto.AbstractDtoOut;
import uu.app.exception.AppErrorMap;

public class SendDtoOut extends AbstractDtoOut {

  private AppErrorMap uuAppErrorMap;

  public AppErrorMap getUuAppErrorMap() {
    return uuAppErrorMap;
  }

  public void setUuAppErrorMap(AppErrorMap uuAppErrorMap) {
    this.uuAppErrorMap = uuAppErrorMap;
  }
}
