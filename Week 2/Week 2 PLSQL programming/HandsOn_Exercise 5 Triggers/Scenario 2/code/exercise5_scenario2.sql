--Create the AuditLog Table
CREATE TABLE AuditLog (
    LogID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    Action VARCHAR2(50),
    LogDate DATE
);
--trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, AccountID, Action, LogDate)
    VALUES (:NEW.TransactionID, :NEW.AccountID, 'Transaction Inserted', SYSDATE);
END;
/
--test
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2001, 1, SYSDATE, 800, 'Deposit');

SELECT * FROM AuditLog ORDER BY LogDate DESC;
