CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount    NUMBER,
    p_interest_rate  NUMBER,
    p_years          NUMBER
) RETURN NUMBER
IS
    v_monthly_rate   NUMBER;
    v_months         NUMBER;
    v_installment    NUMBER;
BEGIN
    -- Convert annual interest rate to monthly rate
    v_monthly_rate := p_interest_rate / (12 * 100);
    v_months := p_years * 12;

    -- EMI formula: P * r * (1 + r)^n / ((1 + r)^n - 1)
    v_installment := p_loan_amount * v_monthly_rate * POWER((1 + v_monthly_rate), v_months) /
                     (POWER((1 + v_monthly_rate), v_months) - 1);

    RETURN ROUND(v_installment, 2);
EXCEPTION
    WHEN ZERO_DIVIDE THEN
        RETURN NULL;
    WHEN OTHERS THEN
        RETURN NULL;
END;
/
--Test the Function
SELECT 
    LoanAmount,
    InterestRate,
    CalculateMonthlyInstallment(LoanAmount, InterestRate, 5) AS Monthly_Installment
FROM Loans;
