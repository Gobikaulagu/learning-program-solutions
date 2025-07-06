-- PL/SQL Block: Generate Monthly Statements using an Explicit Cursor
SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to fetch current month's transactions with customer info
    CURSOR monthly_cursor IS
        SELECT c.CustomerID, c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE TO_CHAR(t.TransactionDate, 'MMYYYY') = TO_CHAR(SYSDATE, 'MMYYYY')
        ORDER BY c.CustomerID, t.TransactionDate;

    -- Record variable for cursor
    transaction_rec monthly_cursor%ROWTYPE;

BEGIN
    -- Open and loop through the cursor
    OPEN monthly_cursor;
    LOOP
        FETCH monthly_cursor INTO transaction_rec;
        EXIT WHEN monthly_cursor%NOTFOUND;

        -- Print transaction info for the customer
        DBMS_OUTPUT.PUT_LINE('Customer: ' || transaction_rec.Name || 
                             ' | Transaction ID: ' || transaction_rec.TransactionID || 
                             ' | Date: ' || TO_CHAR(transaction_rec.TransactionDate, 'DD-MON-YYYY') || 
                             ' | Type: ' || transaction_rec.TransactionType || 
                             ' | Amount: ' || transaction_rec.Amount);
    END LOOP;

    CLOSE monthly_cursor;
END;
/
