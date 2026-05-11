package com.example.lib

//Liskov Subsititution Princile
// super class class objects can be  replaced by sub classes objects and doing that our program did not break so its followings LSP
open class BankAccount{// class that not follow LSp
    val amount: Double=0.0
   open fun getBalance(){
        println(" current Balance:$amount")
    }
     open fun withdrawBalance(){
        println(" WithDraw Balance:$amount")
    }
}
class  savingAccount: BankAccount(){
    override fun withdrawBalance() {
        super.withdrawBalance()
        println(" Saving Account Withdraw:$amount")

    }

}
class FixedAccount: BankAccount(){
    override fun withdrawBalance() {
        throw IllegalAccessException("Fixed Deposite cant withdraw")
    }
}
// Class that follow LSP
interface withdrwa{
    open fun withdraw(amount: Double){}
}
open class bankAccount{// class that not follow LSp
var amount: Double=0.0
    open fun getBalance(){
        println(" current Balance:$amount")
    }
    open fun deposite(amount: Double){
        println("Deposite rs $amount " )
    }

}
class  SavingAccount: BankAccount(), withdrwa{
    override fun withdrawBalance() {
        super.withdrawBalance()
        println(" Saving Account Withdraw:$amount")

    }

    override fun withdraw(amount: Double) {
       println("withdraw $amount")
    }
}
class fixedAccount: bankAccount(){
    var isdep: Boolean=false
    override fun deposite(amount: Double) {
        if (!isdep){
            this.amount=amount
            isdep=true
        }
    }
}