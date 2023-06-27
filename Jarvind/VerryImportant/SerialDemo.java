import java.io.*;

class Dog implements Serializable
{
	int i=10;
	int j=20;
}

class SerialDemo
{
	public static void main(String args[]) throws Exception
	{
		Dog d1=new Dog();

		FileOutputStream fos=new FileOutputStream("object.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(d1);

		Dog d2=new Dog();

		FileInputStream fis=new FileInputStream("object.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		d2=(Dog)ois.readObject();

		System.out.println(d2.i+"-----"+d2.j);

	}
}