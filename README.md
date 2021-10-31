# oodp project class diagram version 2 
changes mostly to split up restaurant app into different boundary classes so its not some gigantic boundary class where if one input needs to change then it affects all the methods that need input -> recompiling would be expensive. 

Also implemented some interfaces for those classes that need to use another class's methods. This is based off the theory behind tutorial 8 qn 2d where Account class has deposit() and withdraw() and XML() method. Another class called BankWebSvc uses Account for its XML() method but if deposit() changes, need to recompile BankWebSvc as well. Therefore use interface instead where BankWebSvc won't need to be recompiled cuz its an interface which shouldnt change anyways since its alr an abstract method, cant do any changes anyway. 

