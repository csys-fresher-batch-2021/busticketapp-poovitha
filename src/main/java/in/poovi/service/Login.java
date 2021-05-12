package in.poovi.service;

public class Login {
	public static boolean login(String username,String password) {
		boolean valid=username.equals("poovi") && password.equals("pass@123");
		return valid;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("In Main...");
		String username="poovi";
		String password="pass@123";
	    boolean isvalid=Login.login(username,password);
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
