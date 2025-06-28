CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acc_rec IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        -- Apply 1% interest
        UPDATE Accounts
        SET Balance = Balance + (acc_rec.Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = acc_rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Interest applied to AccountID: ' || acc_rec.AccountID ||
                             ', New Balance: ' || TO_CHAR(acc_rec.Balance * 1.01, '9999.99'));
    END LOOP;

    COMMIT;
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
SELECT AccountID, AccountType, Balance
     FROM Accounts;