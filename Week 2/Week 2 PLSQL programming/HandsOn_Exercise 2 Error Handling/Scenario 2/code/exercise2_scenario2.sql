CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmpID IN NUMBER,
    p_Percent IN NUMBER
) IS
    v_old_salary Employees.Salary%TYPE;
BEGIN
    -- Try to fetch the current salary
    SELECT Salary INTO v_old_salary
    FROM Employees
    WHERE EmployeeID = p_EmpID;

    -- Update the salary with increment
    UPDATE Employees
    SET Salary = Salary + (Salary * p_Percent / 100)
    WHERE EmployeeID = p_EmpID;

    DBMS_OUTPUT.PUT_LINE('Salary updated for EmployeeID ' || p_EmpID ||
                         '. Old Salary: ' || v_old_salary ||
                         ', New Salary: ' || (v_old_salary + (v_old_salary * p_Percent / 100)));

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: EmployeeID ' || p_EmpID || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

-- Run
SET SERVEROUTPUT ON;

BEGIN
    -- Case 1: Valid employee
    UpdateSalary(1, 10);
    
    -- Case 2: Invalid employee
    UpdateSalary(999, 10);
END;
/
