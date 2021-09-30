package ucl.swap.hack.api;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import ucl.swap.hack.abl.PollAbl;
import ucl.swap.hack.api.dto.PollDtoOut;
import ucl.swap.hack.api.dto.SendDtoIn;
import ucl.swap.hack.api.dto.SendDtoOut;
import ucl.swap.hack.api.dto.SwapHackInitDtoIn;
import uu.app.server.CommandContext;
import uu.app.server.annotation.Command;
import uu.app.server.annotation.CommandController;

@CommandController
public final class PollController {

  @Inject
  private PollAbl pollAbl;

  @Command(path = "polling/poll", method = POST)
  public PollDtoOut poll(CommandContext<SwapHackInitDtoIn> ctx) {
    return pollAbl.poll();
  }

  @Command(path = "polling/send", method = POST)
  public SendDtoOut create(CommandContext<SendDtoIn> ctx) {
    return pollAbl.send(ctx.getDtoIn());
  }

}
