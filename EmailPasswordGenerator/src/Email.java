import java.util.Scanner;
public class Email {
    private String firstname;
    private String lastname;
    private String department;
    private String password;
    private String email;
    private int mailboxCapacity=500;
    private String alternativeEmail;
    private int defaultPasswordLength=10;
    private String companySuffix = "RawanCompany.com";

    public Email(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("Name: "+this.firstname+" "+this.lastname);
        // set department code
        department = setDepartment();
        System.out.println("department: "+this.department);
        // generate random password
        // ask chatgpt why the value of password isn't changing when i re run the object again in debug mood
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("The password is: "+this.password);

        //combine elements to generate password
        if(!department.equals("")){
            this.email = "Email: "+firstname+"."+lastname+"@"+department+"."+companySuffix;
            System.out.println(this.email);
        }else{
            email = "Email: "+firstname+"."+lastname+"@"+companySuffix;
            System.out.println(email);
        }
    }
    // Department name
    // Since the method will be called inside the constructor, it's better to be private
    private String setDepartment(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Department code\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        int code = in.nextInt();
        String dep="";
        switch(code){
            case 1->dep = "Sales";
            case 2->dep =  "Development";
            case 3->dep = "Accounting";
            default->System.out.println("Enter a valid code");}
        in.close();
        return dep;
    }
    //Generate random password
    private String randomPassword(int length){
        // from password set i want to get the chars
        String PasswwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@!#&";
        //Math.random() gives number from 0 to 1 (we want integer values so we cast it with (int)) and we want it to be the same length as of string, so we multiply it with it
        char[] password = new char[length];
        for(int i =0; i<length; i++){
            int rand = (int)(Math.random()*PasswwordSet.length()); 
            password[i] = PasswwordSet.charAt(rand);
        }
        // if you convert char with .toString() whenever the function get called, the value won't change

        return new String(password); // convert char to String
    }
    // set the mailbox capacity
    //we will set it public since it's no need to be called in constructor, it's optional
    public void setMailBoxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    // set alternative email
    public void setAlternativeEmail(String alternativeEmail){
        this.alternativeEmail = alternativeEmail;
    } 
    // change password
    public void setPassword(String password){
        this.password = password;
    }
    // getters method
    public int getMailBoxCapacity(){return mailboxCapacity;}
    public String getAlternativeEmail(){return alternativeEmail;}
    public String getPassword(){return password;}

    // print all the information given
    // we are overriding a bild in method
    public String toString(){return "Info:\nName: "+this.firstname+" "+this.lastname+"\nCompany Email: "+email+"\nMail Box Capacity "+this.mailboxCapacity;}
}
