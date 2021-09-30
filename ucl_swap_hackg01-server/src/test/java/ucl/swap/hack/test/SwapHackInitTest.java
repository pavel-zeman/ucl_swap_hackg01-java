package ucl.swap.hack.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucl.swap.hack.api.dto.SwapHackInitDtoIn;
import ucl.swap.hack.api.dto.SwapHackInitDtoOut;

public class SwapHackInitTest extends SwapHackAbstractTest {

  @Before
  public void setUp() {
    initUuSubAppInstance();
    createUuAppWorkspace(AWID);
  }

  @Test
  public void hdsTest() {
    SwapHackInitDtoIn dtoIn = new SwapHackInitDtoIn();
    dtoIn.setUuAppProfileAuthorities(GG_ALL_URI);
    SwapHackInitDtoOut result = swapHackAbl.init(AWID, dtoIn);
    Assert.assertNotNull(result.getUuAppErrorMap());
  }

}
