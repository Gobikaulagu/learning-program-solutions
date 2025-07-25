SET SERVEROUTPUT ON;

BEGIN
    FOR trans_rec IN (
        SELECT TransactionID, Amount
        FROM Transactions
    ) LOOP
        IF trans_rec.Amount > 50000 THEN
            UPDATE Transactions
            SET Priority = 'HIGH'
            WHERE TransactionID = trans_rec.TransactionID;

            DBMS_OUTPUT.PUT_LINE('TransactionID ' || trans_rec.TransactionID ||
                                 ' is marked HIGH. Amount: ' || trans_rec.Amount);
        END IF;
    END LOOP;

    COMMIT;
END;
/
