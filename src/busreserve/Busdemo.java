package busreserve;
import java.util.ArrayList;
import java.util.Scanner;
public class Busdemo 
{
	public static void main(String[] args)  
	{
		ArrayList<Bus> buses=new ArrayList<Bus>();
		ArrayList<Booking> bookings=new ArrayList<Booking>();
		buses.add(new Bus(1,true,45));
		buses.add(new Bus(2,false,48));
		buses.add(new Bus(3,true,49));
		buses.add(new Bus(4,false,42));
		for(Bus i:buses)
		{
			i.busDetails();
		}
		int useropt=0;
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("Enter 1 to book and 2 to exit");
			useropt=sc.nextInt();
			if(useropt==1)
			{
				Booking booking=new Booking();
				if(booking.isAvailable(bookings,buses))
				{
					bookings.add(booking);
					System.out.println("Your booking is confirmed");
				}
				else 
				{
					System.out.println("Sorry bus is full try another Bus");
				}
			}
		}while(useropt==1);
		if(useropt ==2)
		{
			System.out.println("Thank you");
		}
		sc.close();
	}
}
