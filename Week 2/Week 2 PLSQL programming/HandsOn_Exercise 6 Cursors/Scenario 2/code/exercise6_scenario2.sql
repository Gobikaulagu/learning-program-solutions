-- PL/SQL Block: Apply Annual Fee using an Explicit Cursor
SET SERVEROUTPUT ON;

DECLARE
    -- Declare a fixed annual fee (you can modify this value)
    v_annual_fee NUMBER := 100;

    -- Cursor to fetch all accounts
    CURSOR account_cursor IS
        SELECT AccountID, Balance
        FROM Accounts;

    -- Record variable for each account row
    account_rec account_cursor%ROWTYPE;

BEGIN
    -- Open the cursor
    OPEN account_cursor;

    -- Loop through all accounts
    LOOP
        FETCH account_cursor INTO account_rec;
        EXIT WHEN account_cursor%NOTFOUND;

        -- Deduct annual fee if balance is sufficient
        IF account_rec.Balance >= v_annual_fee THEN
            UPDATE Accounts
            SET Balance = Balance - v_annual_fee
            WHERE AccountID = account_rec.AccountID;

            DBMS_OUTPUT.PUT_LINE('Annual fee applied to AccountID: ' || account_rec.AccountID ||
                                 ' | New Balance: ' || (account_rec.Balance - v_annual_fee));
        ELSE
            DBMS_OUTPUT.PUT_LINE('Skipped AccountID: ' || account_rec.AccountID ||
                                 ' | Insufficient Balance: ' || account_rec.Balance);
        END IF;
    END LOOP;

    -- Close the cursor
    CLOSE account_cursor;

    -- Commit changes
    COMMIT;
END;
/
