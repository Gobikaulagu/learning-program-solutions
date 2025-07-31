SET SERVEROUTPUT ON;

DECLARE
    v_customer_id Customers.CustomerID%TYPE;
    v_age NUMBER;
BEGIN
    FOR customer_rec IN (
        SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
    ) LOOP
        -- Calculate age
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, customer_rec.DOB) / 12);

        IF v_age > 60 THEN
            -- Apply 1% discount
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = customer_rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to CustomerID: ' || customer_rec.CustomerID || 
                                 ', Age: ' || v_age || 
                                 ', New InterestRate applied.');
        END IF;
    END LOOP;

    COMMIT;
END;
/
