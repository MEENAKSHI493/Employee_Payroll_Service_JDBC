    package com.Brirgelab;

    import com.Bridgelab.EmpPayrollData;
    import com.Bridgelab.EmployeePayrollServiceDB;
    import org.junit.Assert;
    import org.junit.jupiter.api.Test;

    import java.util.List;
    public class EmployeePayrollTestDB {
        // checking the given employee payrollData having employee count 3 same in database
        @Test
        public void givenEmployeePayrollDB_WhenRetrived_ShouldMatchTheCount(){
            EmployeePayrollServiceDB employeePayrollServiceDB =new EmployeePayrollServiceDB();
            List<EmpPayrollData>empPayrollDataList=employeePayrollServiceDB.getEmployeeData();
            Assert.assertEquals(3,empPayrollDataList.size());
    }

        @Test
        public void givenEmployeePayrollDB_WhenRetriveddata_ShouldNotMatchTheCount() {
            EmployeePayrollServiceDB employeePayrollServiceDB = new EmployeePayrollServiceDB();
            List<EmpPayrollData> empPayrollDataList = employeePayrollServiceDB.getEmployeeData();
            Assert.assertNotEquals(4, empPayrollDataList.size());
        }
}

