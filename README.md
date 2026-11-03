# Sistem za upravljanje zaposlenicima (Employee Management System)

## Opis projekta

Employee Management System je konzolna aplikacija razvijena u programskom jeziku Java u okviru fakultetske vježbe.

Cilj vježbe je praktična primjena naprednijih koncepata objektno orijentisanog programiranja (OOP) kroz izradu sistema za upravljanje zaposlenicima, njihovim podacima, platama i dodatnim primanjima.

Program omogućava kreiranje različitih kategorija zaposlenika, pohranjivanje njihovih podataka u tekstualnu datoteku, ponovno učitavanje podataka, prikaz informacija, sortiranje prema plati i pronalaženje zaposlenika s najvećom ukupnom zaradom.

## Funkcionalnosti programa

- Kreiranje zaposlenika različitih kategorija.
- Evidentiranje imena, identifikacijskog broja i osnovne plate zaposlenika.
- Podrška za različite vrste zaposlenika: obični zaposlenik, menadžer i pripravnik.
- Evidentiranje dodatnog bonusa za menadžere.
- Evidentiranje škole pripravnika.
- Spremanje podataka o zaposlenicima u tekstualnu datoteku.
- Učitavanje prethodno spremljenih podataka iz datoteke.
- Prikaz detaljnih informacija o zaposlenicima.
- Izračun ukupnih troškova za plate i bonuse.
- Sortiranje zaposlenika prema ukupnoj plati u opadajućem redoslijedu.
- Pronalaženje zaposlenika s najvećom ukupnom zaradom.
- Obrada određenih grešaka prilikom čitanja podataka iz datoteke.

## Korištene tehnologije

- **Java** – glavni programski jezik.
- **IntelliJ IDEA** – razvojno okruženje korišteno za izradu programa.
- **Java Collections Framework** – korišten za organizaciju i upravljanje listom zaposlenika.
- **File Handling** – korišten za čitanje i zapisivanje podataka u tekstualne datoteke.

## Primijenjeni koncepti programiranja

U okviru ove vježbe primijenjeni su sljedeći koncepti:

- **Klase i objekti** – predstavljaju osnovu programa i omogućavaju modeliranje zaposlenika i njihovih podataka.
- **Enkapsulacija** – privatni atributi štite podatke unutar klase, dok getter metode omogućavaju kontrolisan pristup.
- **Nasljeđivanje (Inheritance)** – klase `Manager` i `Intern` nasljeđuju zajedničke osobine i metode bazne klase `Employee`.
- **Polimorfizam (Polymorphism)** – omogućava pozivanje različitih implementacija metoda, zavisno od stvarnog tipa objekta.
- **Preklapanje metoda (Method Overriding)** – podklase prilagođavaju ponašanje metoda `work()` i `getDetails()`.
- **Konstruktori** – koriste se za inicijalizaciju objekata prilikom njihovog kreiranja.
- **ArrayList i List** – omogućavaju dinamičko čuvanje i organizaciju objekata zaposlenika.
- **Rad s datotekama** – klase `FileReader` i `FileWriter` omogućavaju učitavanje i spremanje podataka.
- **Try-with-resources** – omogućava automatsko zatvaranje resursa nakon završetka rada s datotekama.
- **Instanceof i kastovanje (Casting)** – koriste se za provjeru stvarnog tipa objekta i pristup specifičnim atributima podklasa.
- **Collections.sort i Comparator** – koriste se za sortiranje zaposlenika prema plati.
- **Obrada izuzetaka (Exception Handling)** – omogućava prepoznavanje i obradu grešaka tokom rada programa.

## Struktura projekta

```text
Java-Employee-Management/
│
├── src/
│   └── Main.java
│
├── zaposlenici.txt
│
└── README.md
```

*Napomena: Datoteka `zaposlenici.txt` koristi se za pohranjivanje podataka o zaposlenicima i može biti kreirana tokom izvršavanja programa.*

## Pokretanje programa

1. Preuzeti ili klonirati repozitorij sa GitHuba.
2. Otvoriti projekat u razvojnom okruženju IntelliJ IDEA.
3. Otvoriti datoteku `Main.java`.
4. Pokrenuti glavnu metodu `main()`.
5. Program će kreirati početne podatke o zaposlenicima, spremiti ih u tekstualnu datoteku, a zatim ih ponovo učitati i obraditi.
6. Rezultati će biti prikazani u konzoli.

## Način rada aplikacije

Program prvo kreira nekoliko objekata različitih tipova zaposlenika, uključujući obične zaposlenike, menadžere i pripravnike.

Nakon kreiranja, podaci se spremaju u tekstualnu datoteku `zaposlenici.txt`. Lista zaposlenika se zatim čisti, a podaci se ponovo učitavaju iz datoteke kako bi se demonstrirao postupak trajnog zapisivanja i čitanja podataka.

Nakon učitavanja, program prikazuje detaljne informacije o zaposlenicima koristeći polimorfizam. Zatim izračunava ukupne troškove plata i bonusa, sortira zaposlenike prema ukupnoj plati i pronalazi zaposlenika s najvećom ukupnom zaradom.

## Ograničenja programa

Ovo je edukativna konzolna aplikacija namijenjena demonstraciji objektno orijentisanog programiranja i rada s datotekama.

Podaci se čuvaju u jednostavnom tekstualnom formatu, a ne u bazi podataka. Program također ne sadrži grafičko korisničko okruženje niti napredan sistem za upravljanje zaposlenicima.

## Autor

**Mirza Čičkušić**

Student računarstva i informatike  
IPI Akademija Tuzla

---

*Fakultetska vježba iz programiranja u Javi – Sistem za upravljanje zaposlenicima.*


# Employee Management System

## Project Description

Employee Management System is a Java console application developed as part of a university programming exercise.

The purpose of this exercise is to demonstrate the practical application of Object-Oriented Programming (OOP) concepts through the development of a system for managing employees, their personal information, salaries, and additional earnings.

The application supports different types of employees, stores and retrieves employee information from a text file, displays employee details, calculates total expenses, sorts employees by salary, and identifies the employee with the highest total earnings.

## Features

- Create and manage different types of employees.
- Store employee names, identification numbers, and base salaries.
- Support three employee categories: Employee, Manager, and Intern.
- Assign additional bonuses to managers.
- Store educational information about interns.
- Save employee information to a text file.
- Load previously saved employee information from a file.
- Display detailed employee information.
- Calculate total salary expenses, including manager bonuses.
- Sort employees by total salary in descending order.
- Find the employee with the highest total earnings.
- Handle common file-reading and data-conversion errors.

## Technologies Used

- **Java** – Main programming language.
- **IntelliJ IDEA** – Integrated Development Environment (IDE).
- **Java Collections Framework** – Used for storing and managing employee objects.
- **File Handling** – Used for reading and writing employee data to text files.

## Object-Oriented Programming Concepts

This exercise demonstrates the following programming concepts:

- **Classes and Objects** – Provide the foundation for representing employees and their information.
- **Encapsulation** – Private attributes protect internal data, while getter methods provide controlled access.
- **Inheritance** – The `Manager` and `Intern` classes inherit common properties and methods from the base `Employee` class.
- **Polymorphism** – Allows different implementations of methods to be executed depending on the actual object type.
- **Method Overriding** – Subclasses provide their own implementations of the `work()` and `getDetails()` methods.
- **Constructors** – Initialize objects when they are created.
- **ArrayList and List** – Allow dynamic storage and management of employee objects.
- **File Handling** – `FileReader` and `FileWriter` are used to read and write employee information.
- **Try-with-resources** – Automatically closes file resources after operations are completed.
- **Instanceof and Type Casting** – Used to identify object types and access subclass-specific attributes.
- **Collections.sort and Comparator** – Used to sort employees according to their salary.
- **Exception Handling** – Helps identify and handle errors during file operations and data processing.

## Project Structure

```text id="6eq81a"
Java-Employee-Management/
│
├── src/
│   └── Main.java
│
├── zaposlenici.txt
│
└── README.md
```

*Note: The `zaposlenici.txt` file is used to store employee information and may be generated during program execution.*

## How to Run

1. Clone or download this repository from GitHub.
2. Open the project in IntelliJ IDEA.
3. Open the `Main.java` file.
4. Run the `main()` method.
5. The application creates sample employee records, saves them to a text file, and then loads and processes the data again.
6. The results are displayed in the console.

## Application Workflow

The application starts by creating several employee objects of different types, including regular employees, managers, and interns.

After creating the objects, their information is saved to the `zaposlenici.txt` file. The employee list is then cleared, and the information is loaded again from the file to demonstrate file storage and retrieval.

Once the data has been loaded, the application displays detailed employee information using polymorphism. It then calculates total salary expenses and bonuses, sorts employees according to their total salary, and identifies the employee with the highest total earnings.

## Limitations

This is an educational console application designed to demonstrate Object-Oriented Programming concepts and basic file handling in Java.

Employee information is stored in a simple text-file format rather than a database. The application does not include a graphical user interface or an advanced employee management system.

## Author

**Mirza Čičkušić**

Computer Science and Informatics Student  
IPI Akademija Tuzla

---

*University Java Programming Exercise – Employee Management System.*



