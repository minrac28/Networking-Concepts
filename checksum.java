//Design a solution to compute the Internet checksum and verify the same.
import java.io.*;  
import java.util.*;

public class checksum{
	public static void main(String[] args){
			
		//Get the text
		Scanner	DataInput = new Scanner(System.in);
		System.out.print("Enter the text to send: ");
		String dataOriginal = DataInput.nextLine();
		
		//Generate Checksum
		int theChecksum = generateChecksum(dataOriginal,0);
		System.out.println("The Checksum to send is: " + theChecksum);
		
		//Verification of received data with checksum
		System.out.print("Enter the received text: ");
		String dataReceived = DataInput.nextLine();
		System.out.print("Enter the received checksum: ");
		int receivedChecksum = DataInput.nextInt();
		
		receivedChecksum = generateChecksum(dataReceived,receivedChecksum);
	
		if(receivedChecksum == 0)
			System.out.println("The received message is in order.");
		else
			System.out.println("There is an issue with the message.");
	}
	
	//Function to generate the checksum
	static int generateChecksum(String data, int CheckSum){
		for(int i = 0; i < data.length(); i++){
			CheckSum += data.charAt(i);
			if(CheckSum > 255)
				CheckSum -= 255;
		}
		CheckSum = (~CheckSum) & 0xFF;
		return(CheckSum);
	}		
}

