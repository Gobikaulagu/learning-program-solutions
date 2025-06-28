-- PL/SQL Block: Update Loan Interest Rates using an Explicit Cursor
SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to fetch all loans
    CURSOR loan_cursor IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans;

    -- Record variable for each loan row
    loan_rec loan_cursor%ROWTYPE;

BEGIN
    -- Open the cursor
    OPEN loan_cursor;

    -- Loop through all loans
    LOOP
        FETCH loan_cursor INTO loan_rec;
        EXIT WHEN loan_cursor%NOTFOUND;

        IF loan_rec.LoanAmount > 10000 THEN
            -- Increase interest rate by 0.5%
            UPDATE Loans
            SET InterestRate = InterestRate + 0.5
            WHERE LoanID = loan_rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('LoanID ' || loan_rec.LoanID || 
                                 ' | LoanAmount: ' || loan_rec.LoanAmount ||
                                 ' | Interest increased to: ' || (loan_rec.InterestRate + 0.5));
        ELSE
            -- Decrease interest rate by 0.5%
            UPDATE Loans
            SET InterestRate = InterestRate - 0.5
            WHERE LoanID = loan_rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('LoanID ' || loan_rec.LoanID || 
                                 ' | LoanAmount: ' || loan_rec.LoanAmount ||
                                 ' | Interest decreased to: ' || (loan_rec.InterestRate - 0.5));
        END IF;
    END LOOP;

    -- Close the cursor
    CLOSE loan_cursor;

    -- Commit changes
    COMMIT;
END;
/
