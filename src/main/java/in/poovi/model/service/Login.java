package in.poovi.model.service;

public class Login {
	public static boolean login(String username1,String password1) {
		boolean valid=username1.equals("poovi") && password1.equals("Pass@1234");
		return valid;
		
	}
	public static void main(String[] args) {
		String username1="poovi";
		 String password1="Pass@1234";
		   boolean isvalid=Login.login(username1,password1);
		    if(isvalid) 
		    {
			    	System.out.println("LOGIN SUCESSFULLY!!!!!!");
			    }
			   
		    else
		    {
		    	System.out.println("INVALID EMAILID");
		    }
	

	}

}
