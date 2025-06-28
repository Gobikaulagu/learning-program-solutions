CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_pct  IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_pct / 100)
    WHERE Department = p_department;

    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_pct || '% applied to department: ' || p_department);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error applying bonus: ' || SQLERRM);
        ROLLBACK;
END;
/
BEGIN
    UpdateEmployeeBonus('IT', 10); -- Apply 10% bonus to 'IT' department
END;
/
SELECT Name, Department, Salary FROM Employees;

