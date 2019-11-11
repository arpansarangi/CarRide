
String check(Customer c)
{
    String error = "Invalid Credentials";
    if(c.name.length() == 0 || c.userName.length() == 0 || c.password.length() == 0 || c.emailID.length() == 0)
        return error;
    if(c.phoneNumber.length() != 10)
        return error;
    for(char ch : phoneNumber)
        if(ch >= '0' && ch <= '9');
        else
            return error;
    if(c.currentLocation.length() != 2)
        return error;
    if(26*(c.currentLocation[0]-'a')+c.currentLocation[1] <= 37 && 26*(c.currentLocation[0]-'a')+c.currentLocation[1] >= 0);
    else
        return error;
    Boolean flag1 = false, flag2 = false;
    for(char ch : c.emailID)
    {
        if(ch = '@')
            flag1 = true;
        if(ch == '.')
            flag2 = true;
    }
    if(!(flag1 && flag2))
        return error;
    String empty = "";
    return empty;
}
