# Program description
print("This is an interest calculating program")
print("You will need to input the initial amount,")
print("the amount you will deposit each month, the")
print("annual interest rate, and the number of years.")
print("===============================================")
print("The program will show you the balance and interest,")
print("without additional deposits, and the amount with")
print("additional deposits.")
print("")

# Inputs
print("====================================")
print("         Input data below")
print("====================================")
initial_amount = float(input("Initial Investment: $"))
monthly_deposit = float(input("Monthly Deposit: $"))
annual_interest = float(input("Annual Interest: %"))
years = float(input("Number of years: "))
months = years * 12

# Initial amount
total_amount = initial_amount
print("\n   Balance and Interest Without Additional Monthly Deposits")
print("================================================================")
print("Year\t\tYear End Balance\tYear End Earned Interest")
print("----------------------------------------------------------------")

# Figure total interest
for i in range(int(years)):
    # Yearly interest
    interest_amount = total_amount * (annual_interest / 100)
    # Total year total
    total_amount += interest_amount
    # set fixed and 2 decimal places
    print(f"{i + 1}\t\t\t\t${total_amount:.2f}\t\t\t\t${interest_amount:.2f}")

# Total
total_amount = initial_amount

# Deposits
print("\n\n   Balance and Interest With Additional Monthly Deposits")
print("================================================================")
print("Year\t\tYear End Balance\tYear End Earned Interest")
print("----------------------------------------------------------------")

# Interest and deposits
for i in range(int(years)):
    # yearly interest zero percent at the beginning of the year
    total_year = 0
    for j in range(12):
        # monthly interest
        interest_amount = (total_amount + monthly_deposit) * ((annual_interest / 100) / 12)
        # month end interest
        total_year += interest_amount
        # month end total
        total_amount += monthly_deposit + interest_amount
    print(f"{i + 1}\t\t\t\t${total_amount:.2f}\t\t\t\t${total_year:.2f}")
