package busreserve;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking 
{
	String passenger;
	int busNo;
	Date date;
	Booking() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name of the passenger: ");
		passenger=sc.nextLine();
		System.out.println("Enter busNo: ");
		busNo=sc.nextInt();
		System.out.println("Enter date dd-mm-yyyy ");
		String dateinput = sc.next();
		SimpleDateFormat date1=new SimpleDateFormat("dd-mm-yyyy");
		try 
		{
			date=date1.parse(dateinput);
		} 
		catch (ParseException e) 
		{

		}
		sc.close();
	}
	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) 
	{
		int capacity=0;
		for(Bus bus:buses)
		{
			if(bus.getBusNo()==busNo)
			{
				capacity=bus.getCapacity();
			}
		}
		int booked=0;
		for(Booking b:bookings)
		{
			if(b.busNo==busNo && b.date.equals(date))
			{
				booked++;
			}
		}
		return booked<capacity?true:false;
	}
}
