package com.neoteric.java1807.service;

import com.neoteric.java1807.model.*;

import java.util.UUID;

public class LoanService {

    public void getApplication(ApplicationDetails applicationDetails){
        String applicationNumber = UUID.randomUUID().toString();
      if(applicationDetails.incomeDetails.incomeAmount>applicationDetails.incomeDetails.monthlyExcpensess){
          System.out.println("Eligible For Loan ");
          System.out.println("Application Number = "+applicationNumber);
      }else{
          System.out.println("Not Eligible ");
      }
    }

    public double isEligibleToLoan(IncomeDetails incomeDetails){
       double savings = incomeDetails.incomeAmount- incomeDetails.monthlyExcpensess;
       double loanAmount=savings*10;
        System.out.println("You Are Eligible For This Loan Amount Only = "+loanAmount);
        return  savings;
    }


    public double getLoan(LoanDetails loanDetails){
        double savings = loanDetails.applicationDetails.incomeDetails.incomeAmount- loanDetails.applicationDetails.incomeDetails.monthlyExcpensess;
        double loanAmount=savings*10;
        //double finalLoanAmount=loanAmount+loanDetails.interestRate;
        double emiSaving=0.6*savings;
         loanDetails.emiAmount= loanAmount/loanDetails.loanTerm;
        String loanNumber = UUID.randomUUID().toString();

        if(emiSaving>=loanDetails.emiAmount){
            System.out.println("Your Loan Approved");
            System.out.println("Loan Number = "+loanNumber);
            System.out.println("For Monthly Emi = "+loanDetails.emiAmount);

        }else {
            System.out.println("Not Approved");
        }
        return emiSaving;
    }
    /*public static void main(String[] args) {
        IncomeDetails incomeDetails = new IncomeDetails();
        incomeDetails.incomeAmount=50000;
        incomeDetails.monthlyExcpensess=20000;
        LoanService loanService = new LoanService();
        ApplicationDetails applicationDetails=new ApplicationDetails();
        applicationDetails.incomeDetails=incomeDetails;
        Address address = new Address();
        EmployementDetails employementDetails= new EmployementDetails();

        PersonalDetails personalDetails = new PersonalDetails();
        LoanDetails loanDetails = new LoanDetails();
        loanDetails.loanTerm=24;
        loanDetails.interestRate=0.2;
        loanDetails.applicationDetails=applicationDetails;



        loanService.getApplication(applicationDetails);
        loanService.getLoan(loanDetails);

        System.out.println(loanService);


    }*/


}
