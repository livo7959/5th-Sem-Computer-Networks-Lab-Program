import java.math.BigInteger;
import java.util.*;
class RSAEncDec
{
	public static void main(String args[])
	{
		BigInteger bigB_pubkey=new BigInteger(args[0]);
		BigInteger bigB_prvkey=new BigInteger(args[1]);
		BigInteger bigB_n=new BigInteger(args[2]);
		int asciiVal=Integer.parseInt(args[3]);
		BigInteger bigB_val=new BigInteger(""+asciiVal);
		BigInteger bigB_cipherVal=bigB_val.modPow(bigB_pubkey,bigB_n);
		System.out.println("Cipher text: "+bigB_cipherVal);
		BigInteger bigB_plainVal=bigB_cipherVal.modPow(bigB_prvkey,bigB_n);
		int plainVal=bigB_plainVal.intValue();
		System.out.println("Plain text:"+plainVal);
	}
}

