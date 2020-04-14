package com.yedam.config.JavaTest1;

public class JavaTestStream {
   String firstName;
   int salary;

   public String getFirstName() {
      return firstName;
   }

   public int getSalary() {
      return salary;
   }

   public JavaTestStream(String firstName, int salary) {
      super();
      this.firstName = firstName;
      this.salary = salary;
   }

   @Override
   public String toString() {
      return "Employee [이름은 :" + firstName + ", 급여는 :" + salary + "]";
   }
}