package ucl.swap.hack.api.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import uu.app.dto.AbstractDtoOut;
import uu.app.exception.AppErrorMap;

public class PollDtoOut extends AbstractDtoOut {

  private AppErrorMap uuAppErrorMap;

  private String message;

  public PollDtoOut(String message) {
    this.message = message;
  }

  public AppErrorMap getUuAppErrorMap() {
    return uuAppErrorMap;
  }

  public void setUuAppErrorMap(AppErrorMap uuAppErrorMap) {
    this.uuAppErrorMap = uuAppErrorMap;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
