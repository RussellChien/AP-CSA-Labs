public class Contact {
    private String firstname;
    private String lastname;
    private String email;
    public Contact(String fn, String ln, String em){
        firstname = fn;
        lastname = ln;
        email = em;
    }
    public String toString(){
        return firstname+" "+lastname+" \n"+email;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getUsername(){
        return email.substring(0,email.indexOf('@'));
    }
	  public String getDomain(){
		    return email.substring(email.indexOf('@')+1, email.lastIndexOf('.'));
	  }
	  public String getDomainExtension(){
		    return email.substring(email.lastIndexOf('.')+1, email.length());
	  }
}
