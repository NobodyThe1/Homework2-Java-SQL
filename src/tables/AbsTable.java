package tables;

import db.IDBExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void selectFromTable(String item, String column, String attribute) {
        rsExecutor(String.format("select %s from %s where %s='%s'", item, tableName, column, attribute));
    }

    public void count(String item) {
        rsExecutor(String.format("select count(%s) from %s", item, tableName));
    }

    public void update(String item, int newValue, String column, int attribute) {
        dbExecutor.execute(String.format("update %s set %s=%d where %s=%d", tableName, item, newValue, column, attribute));
    }

    public void joinTwoTables(String table2, String columnTable1, String columnTable2) {
        rsExecutor(String.format("select * from %s join %s on %s.%s=%s.%s", tableName, table2, tableName, columnTable1, table2, columnTable2));
    }

    public void joinThreeTables(String table2, String table3, String id, String name, String sex, String groupId, String curatorId) {
        rsExecutor(String.format("select %s.%s, %s.%s, %s.%s, %s.%s, %s.%s, %s.%s from %s, %s, %s where %s.%s=%s.%s and %s.%s=%s.%s",
                tableName, id, tableName, name, tableName, sex, tableName, groupId, table2, name, table3, name, tableName, table2, table3, tableName, groupId,
                table2, id, table3, id, table2, curatorId));
    }

    public void nestedQuery(String item, String column, String table2, String nestedItem, String nestedColumn, String nestedColumnValue) {
        rsExecutor(String.format("select %s from %s where %s = (select %s from %s where %s='%s')", item, tableName, column,
                nestedItem, table2, nestedColumn, nestedColumnValue));
    }


    public void rsExecutor(String query) {
        ResultSet rs = dbExecutor.executeQuery(query);
        try {
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.println(rs.getString(i));
                }
            } System.out.println();
        } catch(SQLException e){
                throw new RuntimeException(e);
        }
    }
}