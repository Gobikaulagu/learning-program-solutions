-- Step 2: Create Package Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    -- Procedure to add a new customer
    PROCEDURE AddCustomer(
        p_CustomerID IN NUMBER,
        p_Name       IN VARCHAR2,
        p_DOB        IN DATE,
        p_Balance    IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);

        DBMS_OUTPUT.PUT_LINE('Customer added successfully.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');
    END AddCustomer;

    -- Procedure to update existing customer details
    PROCEDURE UpdateCustomer(
        p_CustomerID IN NUMBER,
        p_Name       IN VARCHAR2,
        p_Balance    IN NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name,
            Balance = p_Balance,
            LastModified = SYSDATE
        WHERE CustomerID = p_CustomerID;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer not found.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer updated successfully.');
        END IF;
    END UpdateCustomer;

    -- Function to get the current balance of a customer
    FUNCTION GetCustomerBalance(
        p_CustomerID IN NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_CustomerID;

        RETURN v_balance;

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer not found.');
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
/
-- Step 3: Add a new customer
BEGIN
    CustomerManagement.AddCustomer(10, 'Prakash', TO_DATE('1999-05-20','YYYY-MM-DD'), 8000);
END;
/
-- Step 4: Update existing customer details
BEGIN
    CustomerManagement.UpdateCustomer(10, 'Prakash Kumar', 12000);
END;
/
-- Step 5: Get the balance of a customer
DECLARE
    bal NUMBER;
BEGIN
    bal := CustomerManagement.GetCustomerBalance(10);
    DBMS_OUTPUT.PUT_LINE('Balance: ' || bal);
END;
/
