package tables;

import data.Group;
import db.IDBExecutor;
import java.util.List;

public class GroupTable extends AbsTable {

    public GroupTable(IDBExecutor idbExecutor) {
        super("group_students", idbExecutor);
    }

    public void insert(List<String> columns, Group group) {
        dbExecutor.execute(String.format("insert into %s (%s) values (%d, '%s', %d)", tableName, String.join(",", columns),
                group.getId(), group.getName(), group.getIdCurator()));
    }
}