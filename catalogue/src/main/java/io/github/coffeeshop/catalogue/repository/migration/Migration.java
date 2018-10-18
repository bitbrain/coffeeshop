package io.github.coffeeshop.catalogue.repository.migration;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@ChangeLog
public class Migration {

   @ChangeSet(order = "001", id = "1__initial", author = "bitbrain")
   public void initialsetup(DB db) {
      DBCollection products = db.getCollection("products");
      products.insert(
            BasicDBObjectBuilder.start()
                  .add("name", "Flat White")
                  .add("description", "A smooth experience with a nutty finish")
                  .add("imageUrl", "https://www.northstarroast.com/wp-content/uploads/2016/05/NORTH-STAR-S1-8857.jpg")
                  .add("code", "flat-white")
                  .get());
   }

}
