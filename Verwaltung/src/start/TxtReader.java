package start;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import persons.Human;

public class TxtReader {
	
	private Storage storage;

	public TxtReader(Storage stor) {
		storage = stor;
	}


	public void read(String file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file)) ){
			
			String line, surname, forename;
			int age, commaIndex;
			char sex;
			while ((line = reader.readLine()) != null) {
				
				commaIndex = line.indexOf(',');
				surname = line.substring(0, commaIndex );
				line = line.substring(commaIndex+1, line.length()).trim();
				
				commaIndex = line.indexOf(',');
				forename = line.substring(0, commaIndex );
				line = line.substring(commaIndex+1, line.length()).trim();
				
				commaIndex = line.indexOf(',');
				age = Integer.parseInt(line.substring(0, commaIndex ) );
				line = line.substring(commaIndex+1, line.length()).trim();
				
				commaIndex = line.indexOf(',');
				sex = line.charAt( 0  );
				line = line.substring(commaIndex+1, line.length()).trim();
				
				storage.insertPerson(new Human(surname, forename, age, sex));
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
		}
		
	}

}
