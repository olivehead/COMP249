import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.Serializable;

public class Driver {

	public static void main(String[] args) {
		Cars c1 = new Cars(), c2 = new Cars("Toyota", 23000, 2), c3 = new Cars();
		Motorcycles mc1 = new Motorcycles(), mc2 = new Motorcycles(), mc3 = new Motorcycles();

		Vehicle[] v1 = { c1, c1, c3, mc1, mc2, mc3 };

		String fileName, newBrand;

		Scanner kb = new Scanner(System.in);

		System.out.print("Please enter the \"binary\" file name to which the objects should be stored: ");
		fileName = kb.next();

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			// Create an ObjectOutputStream to write into the binary file
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			// If this point is reached, then the stream was created
			// successfully.
			// So, start writing the objects to the file.
			oos.writeObject(v1);

			oos.close();
			System.out.println("Objects have been written to the file " + fileName + ".");
		} catch (IOException e) {
			System.out.println("Error: Problem Reading from file: " + fileName + ".");
			System.out.println("Program will terminate.");
			System.exit(0);
		}

		// Now the file has been created; try to open it and read the objects
		try {
			// Create an ObjectOutputStream to write into the binary file
			ois = new ObjectInputStream(new FileInputStream(fileName));

			// If this point is reached, then the stream was created
			// successfully.
			// So, start reading the objects from the file.
			Vehicle[] v2;
			int i = 1;

			System.out.println("\nWill start displaying the objects stored in file: \"" + fileName + "\".");
			System.out.println("================================================================ ");
			try {
				while (true) {
					v2 = (Vehicle[]) ois.readObject(); // Notice the type cast
														// here;
														// this is the reason
					// that we need to handle ClassNotFoundException
					for (int x = 0; x < v2.length; x++) {
						// System.out.println("Input new vehicle brand:");
						// newBrand = kb.next();
						// if (v2[i].getBrand().equals(newBrand)) {
						// System.out.println("This brand is a duplicate");
						// }
						System.out.println("\nHere is the information of object # " + i++ + ":");
						System.out.println("====================================== ");
						System.out.println(v2[i]);
					}
					for (int j = 0; j < v2.length; j++) {
						if (v2[j].equals(mc2)) {
							System.out.println("This Vehicle is a duplicate");
						} else
						{
							oos.writeObject(mc2);
						}
					}
					System.out.println();
				}
			} catch (ClassNotFoundException e) {
				System.out.println("Error has occurred while reading the file: " + fileName + ".");
			} catch (EOFException e) {
				System.out.println("\nReading file \"" + fileName + "\" has been completed.");
			}
			ois.close(); // Close the file
		} catch (FileNotFoundException e) {
			System.out.println("File: " + fileName + " could not been found.");
			System.out.println("Program will terminate.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Error: Problem Reading from file: " + fileName + ".");
			System.out.println("Program will terminate.");
			System.exit(0);
		}

	}

}
