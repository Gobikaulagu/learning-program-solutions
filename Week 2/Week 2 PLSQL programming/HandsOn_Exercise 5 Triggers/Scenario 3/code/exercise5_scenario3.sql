-- Create Trigger: Enforce business rules on deposits and withdrawals
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- Step 1: Fetch current balance of the account
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    -- Step 2: Check for withdrawal rule violation
    IF :NEW.TransactionType = 'Withdrawal' THEN
        IF :NEW.Amount > v_balance THEN
            -- Raise error if withdrawal exceeds balance
            RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds current balance.');
        END IF;

    -- Step 3: Check for deposit rule violation
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            -- Raise error if deposit amount is zero or negative
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    END IF;
END;
/
