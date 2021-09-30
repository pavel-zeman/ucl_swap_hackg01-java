package ucl.swap.hack.api;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.inject.Inject;
import uu.app.server.CommandContext;
import uu.app.server.annotation.Command;
import uu.app.server.annotation.CommandController;
import ucl.swap.hack.api.dto.SwapHackInitDtoIn;
import ucl.swap.hack.api.dto.SwapHackInitDtoOut;
import ucl.swap.hack.abl.SwapHackAbl;

@CommandController
public final class SwapHackController {

  public static final String WORKSPACE_INIT_CMD = "sys/uuAppWorkspace/init";

  @Inject
  private SwapHackAbl swapHackAbl;

  @Command(path = WORKSPACE_INIT_CMD, method = POST)
  public SwapHackInitDtoOut create(CommandContext<SwapHackInitDtoIn> ctx) {
    SwapHackInitDtoOut dtoOut = swapHackAbl.init(ctx.getUri().getAwid(), ctx.getDtoIn());
    return dtoOut;
  }

}
