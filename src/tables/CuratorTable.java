package tables;

import data.Curator;
import db.IDBExecutor;
import java.util.List;

public class CuratorTable extends AbsTable {

    public CuratorTable(IDBExecutor idbExecutor) {
        super("curator", idbExecutor);
    }

    public void insert(List<String> columns, Curator curator) {
        dbExecutor.execute(String.format("insert into %s (%s) values (%d, '%s')", tableName, String.join(",", columns),
                curator.getId(), curator.getName()));
    }
}