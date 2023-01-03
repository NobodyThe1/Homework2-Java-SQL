import data.Curator;
import data.Group;
import data.Student;
import db.IDBExecutor;
import db.MySQLExecutor;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;
import java.util.*;

public class Main {

       public static void main(String[] args) {

       IDBExecutor dbExecutor = new MySQLExecutor();
          Student student1 = new Student(1, "Иванов Иван", 'm', 1);
          Student student2 = new Student(2, "Петров Пётр", 'm', 2);
          Student student3 = new Student(3, "Кольцова Мария", 'f', 3);
          Student student4 = new Student(4, "Ануфриева Елена", 'f', 1);
          Student student5 = new Student(5, "Александров Александр", 'm', 2);
          Student student6 = new Student(6, "Сидоров Олег", 'm', 3);
          Student student7 = new Student(7, "Рогова Дарья", 'f', 1);
          Student student8 = new Student(8, "Лаврова Ирина", 'f', 2);
          Student student9 = new Student(9, "Павлов Павел", 'm', 3);
          Student student10 = new Student(10, "Осипов Денис", 'm', 1);
          Student student11 = new Student(11, "Гордеева Наталья", 'f', 2);
          Student student12 = new Student(12, "Дружинина Надежда", 'f', 3);
          Student student13 = new Student(13, "Николаев Николай", 'm', 1);
          Student student14 = new Student(14, "Лаврентьев Геннадий", 'm', 2);
          Student student15 = new Student(15, "Алексеева Евгения", 'f', 3);

          try {
               StudentTable studentTable = new StudentTable(dbExecutor);

               List<String> columnsStudentTable = new ArrayList<>();
               columnsStudentTable.add("id int primary key");
               columnsStudentTable.add("name varchar(70)");
               columnsStudentTable.add("sex varchar(1)");
               columnsStudentTable.add("groupId int");

               studentTable.create(columnsStudentTable);

               List<String> studentColumns = new ArrayList<>();
               studentColumns.add("id");
               studentColumns.add("name");
               studentColumns.add("sex");
               studentColumns.add("groupId");

               studentTable.insert(studentColumns, student1);
               studentTable.insert(studentColumns, student2);
               studentTable.insert(studentColumns, student3);
               studentTable.insert(studentColumns, student4);
               studentTable.insert(studentColumns, student5);
               studentTable.insert(studentColumns, student6);
               studentTable.insert(studentColumns, student7);
               studentTable.insert(studentColumns, student8);
               studentTable.insert(studentColumns, student9);
               studentTable.insert(studentColumns, student10);
               studentTable.insert(studentColumns, student11);
               studentTable.insert(studentColumns, student12);
               studentTable.insert(studentColumns, student13);
               studentTable.insert(studentColumns, student14);
               studentTable.insert(studentColumns, student15);

           } finally {
               dbExecutor.close();
           }

          Group group1 = new Group(1, "First", 1);
          Group group2 = new Group(2, "Second", 2);
          Group group3 = new Group(3, "Third", 3);

           try {
               GroupTable groupTable = new GroupTable(dbExecutor);
               List<String> columnsGroupTable = new ArrayList<>();
               columnsGroupTable.add("id int primary key");
               columnsGroupTable.add("name varchar(70)");
               columnsGroupTable.add("curatorId int");
               groupTable.create(columnsGroupTable);

               List<String> groupColumns = new ArrayList<>();
               groupColumns.add("id");
               groupColumns.add("name");
               groupColumns.add("curatorId");

               groupTable.insert(groupColumns, group1);
               groupTable.insert(groupColumns, group2);
               groupTable.insert(groupColumns, group3);

           } finally {
               dbExecutor.close();
           }

          Curator curator1 = new Curator(1, "Гаврилов Н.И.");
          Curator curator2 = new Curator(2, "Шевченко Е.А.");
          Curator curator3 = new Curator(3, "Поляков И.А");
          Curator curator4 = new Curator(4, "Андреева Н.В.");

           try {
               CuratorTable curatorTable = new CuratorTable(dbExecutor);
               List<String> columnsCuratorTable = new ArrayList<>();
               columnsCuratorTable.add("id int primary key");
               columnsCuratorTable.add("name varchar(70)");
               curatorTable.create(columnsCuratorTable);

               List<String> curatorColumns = new ArrayList<>();
               curatorColumns.add("id");
               curatorColumns.add("name");

               curatorTable.insert(curatorColumns, curator1);
               curatorTable.insert(curatorColumns, curator2);
               curatorTable.insert(curatorColumns, curator3);
               curatorTable.insert(curatorColumns, curator4);

           } finally {
               dbExecutor.close();
           }
      }
}