CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN NUMBER,
    p_Name IN VARCHAR2,
    p_DOB IN DATE,
    p_Balance IN NUMBER
) IS
BEGIN
    -- Try to insert new customer
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);

    DBMS_OUTPUT.PUT_LINE('Customer inserted successfully. ID: ' || p_CustomerID);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_CustomerID || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

SET SERVEROUTPUT ON;

BEGIN
    -- Case 1: Insert new customer (should succeed)
    AddNewCustomer(10, 'Test Customer', TO_DATE('1992-10-10', 'YYYY-MM-DD'), 5000);

    -- Case 2: Insert existing customer ID (should fail)
    AddNewCustomer(10, 'Duplicate Customer', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 10000);
END;
/
