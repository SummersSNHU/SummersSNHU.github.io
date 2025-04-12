/*
 * Investment.cpp
 *
 *  Date: 06/03/2023
 *  Author: Ryan Summers
 */

#include <iostream>
#include <iomanip>

using namespace std;

// Set variables
float initialAmount;
float monthlyDeposit;
float annualInterest;
float years;
float months;
float totalAmount;
float interestAmount;
float totalYear;

int main()
{
	// Menu
	cout << "************************************\n";
	cout << "************ DATA INPUT ************\n";
	cout << "Initial Investment Amount: \n";
	cout << "Monthly Deposit: \n";
	cout << "Annual Interest: \n";
	cout << "Number of years: \n";
	system("PAUSE");
	// Inputs
	cout << "************************************\n";
	cout << "************ DATA INPUT ************\n";
	cout << "Initial Investment Amount: $";
	cin >> initialAmount;
	cout << "Monthly Deposit: $";
	cin >> monthlyDeposit;
	cout << "Annual Interest: %";
	cin >> annualInterest;
	cout << "Number of years: ";
	cin >> years;
	months = years * 12;
	system("PAUSE");

	// Initial amount
	totalAmount = initialAmount;
	cout << "\n   Balance and Interest Without Additional Monthly Deposits\n";
	cout << "================================================================\n";
	cout << "Year\t\tYear End Balance\tYear End Earned Interest\n";
	cout << "----------------------------------------------------------------\n";

	// Figure total interest
	for (int i = 0; i < years; i++)
	{
		// Yearly interest
		interestAmount = totalAmount * (annualInterest / 100);
		// Total year total
		totalAmount = totalAmount + interestAmount;
		// set fixed and 2 decimal places
		cout << (i + 1) << "\t\t$" << fixed << setprecision(2) << totalAmount << "\t\t\t$" << interestAmount << "\n";
	}

	// Total
	totalAmount = initialAmount;

	// Deposits
	cout << "\n\n   Balance and Interest With Additional Monthly Deposits\n";
	cout << "================================================================\n";
	cout << "Year\t\tYear End Balance\tYear End Earned Interest\n";
	cout << "----------------------------------------------------------------\n";

	// Interst and deposits 
	for (int i = 0; i < years; i++)
	{
		// yearly interest zero percent at the begining of the year
		totalYear = 0;
		for (int j = 0; j < 12; j++)
		{
			// monthly interest
			interestAmount = (totalAmount + monthlyDeposit) * ((annualInterest / 100) / 12);
			// month end interest
			totalYear = totalYear + interestAmount;
			// month end total 
			totalAmount = totalAmount + monthlyDeposit + interestAmount;
		}
		cout << (i + 1) << "\t\t$" << fixed << setprecision(2) << totalAmount << "\t\t\t$" << totalYear << "\n";
	}
	return 0;
}
