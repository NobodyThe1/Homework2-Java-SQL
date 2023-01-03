package tables;

import db.IDBExecutor;
import java.util.List;

public abstract class AbsTable {
    protected String tableName;
    protected IDBExecutor dbExecutor;

    public AbsTable(String tableName, IDBExecutor dbExecutor) {
        this.tableName = tableName;
        this.dbExecutor = dbExecutor;
    }

    public void create(List<String> columns) {
        dbExecutor.execute(String.format("create table %s (%s)", tableName, String.join(",", columns)));
    }

    public void delete() {
        dbExecutor.execute(String.format("drop table %s", tableName));
    }
}