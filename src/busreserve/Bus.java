package busreserve;
public class Bus 
{
	private int busNo;
	private boolean ac;
	private int capacity;
	Bus(int bNo,boolean ac,int cap)
	{
		this.setBusNo(bNo);
		this.setAc(ac);
		this.setCapacity(cap);
	}
	public int getBusNo() //accessor method
	{
		return busNo;
	}
	public void setBusNo(int busNo) //mutator method
	{
		this.busNo = busNo;
	}
	public boolean isAc() 
	{
		return ac;
	}
	public void setAc(boolean ac) 
	{
		this.ac = ac;
	}
	public int getCapacity() 
	{
		return capacity;
	}
	public void setCapacity(int capacity) 
	{
		this.capacity = capacity;
	}
	public void busDetails()
	{
		System.out.println("BUS_NO:"+busNo+" AC:"+ac+" TOTAL CAPACITY:"+capacity);
	}
}
