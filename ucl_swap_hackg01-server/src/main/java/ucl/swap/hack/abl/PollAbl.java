package ucl.swap.hack.abl;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import ucl.swap.hack.api.dto.PollDtoOut;
import ucl.swap.hack.api.dto.SendDtoIn;
import ucl.swap.hack.api.dto.SendDtoOut;
import ucl.swap.hack.dao.SwapHackDao;
import ucl.swap.hack.utils.ObjectHolder;
import uu.app.validation.Validator;
import uu.app.workspace.api.Profile;

@Component
public final class PollAbl {

  private List<ObjectHolder<PollDtoOut>> holders = new ArrayList<>();

  private Object lock = new Object();

  @Inject
  private Validator validator;

  @Inject
  private Profile profile;

  @Inject
  private SwapHackDao swapHackDao;

  public PollDtoOut poll() {
    ObjectHolder<PollDtoOut> holder = new ObjectHolder<>();
    synchronized (lock) {
      holders.add(holder);
    }
    return holder.get();
  }

  public SendDtoOut send(SendDtoIn dtoIn) {
    synchronized (lock) {
      for (ObjectHolder<PollDtoOut> holder : holders) {
        holder.set(new PollDtoOut(dtoIn.getMessage()));
      }
      holders.clear();
    }
    return new SendDtoOut();
  }
}
