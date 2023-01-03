package tables;

import data.Student;
import db.IDBExecutor;
import java.util.List;

public class StudentTable extends AbsTable {

    public StudentTable(IDBExecutor idbExecutor) {
        super("student", idbExecutor);
    }

    public void insert(List<String> columns, Student student) {
        dbExecutor.execute(String.format("insert into %s (%s) values (%d, '%s', '%c', %d)", tableName, String.join(",", columns),
                student.getId(), student.getName(), student.getSex(), student.getGroupId()));
    }
}