package ucl.swap.hack.dao.mongo;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.index.Index;
import uu.app.objectstore.annotations.ObjectStoreDao;
import uu.app.objectstore.mongodb.dao.UuObjectMongoDao;
import ucl.swap.hack.dao.SwapHackDao;
import ucl.swap.hack.abl.entity.SwapHack;

@ObjectStoreDao(entity = SwapHack.class, store = "primary")
public class SwapHackMongoDao extends UuObjectMongoDao<SwapHack> implements SwapHackDao {

 public void createSchema() {
   super.createSchema();
   createIndex(new Index().on(ATTR_AWID, Direction.ASC).unique());
 }

}
