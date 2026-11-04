//U ovoj vjezbi prikazan je zadatak za sustav upravljanja zaposlenicima (EMS - Employee-Manager System),
// koji se fokusira na koncepte objektno orijentiranog programiranja kao što su nasljeđivanje,
// preopterećenje/nadjačavanje metoda,rad s kolekcijama i datotekama.

// Uvoz klase BufferedReader koja omogućava efikasno čitanje teksta iz datoteke.
import java.io.BufferedReader;

// Uvoz klase FileReader koja služi za otvaranje i čitanje tekstualnih datoteka.
import java.io.FileReader;

// Uvoz klase FileWriter koja omogućava upisivanje podataka u tekstualne datoteke.
import java.io.FileWriter;

// Uvoz klase IOException koja predstavlja greške nastale prilikom rada s datotekama.
import java.io.IOException;

// Uvoz klase ArrayList koja predstavlja dinamičku listu čiji se kapacitet automatski povećava.
import java.util.ArrayList;

// Uvoz klase Collections koja sadrži pomoćne metode za rad s kolekcijama, uključujući sortiranje.
import java.util.Collections;

// Uvoz interfejsa Comparator koji omogućava definisanje vlastitih pravila sortiranja objekata.
import java.util.Comparator;

// Uvoz interfejsa List koji predstavlja listu elemenata.
import java.util.List;
import java.time.LocalDate;
import java.time.Period;


// ==========================================
// BAZNA KLASA: Employee
// ==========================================

// Definisanje osnovne klase Employee koja predstavlja zaposlenika.
// Ostale klase Manager i Intern nasljeđuju njene atribute i metode.
class Employee implements Comparable<Employee>, Cloneable {

    // Privatni atribut koji čuva ime zaposlenika.
    // private znači da mu se ne može direktno pristupiti izvan klase.
    private String name;

    // Privatni atribut koji čuva jedinstveni identifikacijski broj zaposlenika.
    private int id;

    // Privatni atribut koji čuva osnovnu platu zaposlenika.
    private double salary;

    // Datum kada je zaposlenik počeo raditi u firmi.
    private LocalDate hireDay;


    // Konstruktor bazne klase Employee.
    // Poziva se prilikom kreiranja novog objekta klase Employee.
    // Parametri omogućavaju unos imena, ID broja i plate.
    public Employee(String name, int id, double salary) {

        this(name, id, salary, LocalDate.now());
    }

    // Konstruktor koji omogućava unos stvarnog datuma zaposlenja.
    public Employee(String name, int id, double salary, LocalDate hireDay) {

        // Dodjeljivanje vrijednosti parametra name atributu objekta.
        // this.name označava atribut trenutnog objekta.
        this.name = name;

        // Dodjeljivanje identifikacijskog broja zaposlenika.
        this.id = id;

        // Dodjeljivanje osnovne plate zaposlenika.
        this.salary = salary;
        this.hireDay = hireDay;
    }


    // Getter metoda koja vraća ime zaposlenika.
    // Koristi se za pristup privatnom atributu name.
    public String getName() {
        return name;
    }


    // Getter metoda koja vraća ID zaposlenika.
    public int getId() {
        return id;
    }


    // Getter metoda koja vraća osnovnu platu zaposlenika.
    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() { return hireDay; }

    // Broj punih godina od datuma zaposlenja do danas.
    public int getYearsOfService() {
        return Math.max(0, Period.between(hireDay, LocalDate.now()).getYears());
    }


    // Metoda work() predstavlja osnovnu aktivnost zaposlenika.
    // U ovom slučaju ispisuje poruku da zaposlenik radi.
    public void work() {
        System.out.println(name + " is working.");
    }


    // Metoda getDetails() vraća tekstualni prikaz osnovnih podataka zaposlenika.
    // Podaci se spajaju pomoću operatora +.
    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Salary: $" + salary
                + ", Hire day: " + hireDay + ", Years at firm: " + getYearsOfService();
    }

    // Prirodni redoslijed zaposlenika je po ID-u.
    @Override
    public int compareTo(Employee other) { return Integer.compare(this.id, other.id); }

    // Sva polja su primitive vrijednosti ili immutable objekti (String, LocalDate),
    // zato je kopija koju daje Object.clone() sigurna i nezavisna.
    @Override
    public Employee clone() {
        try { return (Employee) super.clone(); }
        catch (CloneNotSupportedException e) { throw new AssertionError(e); }
    }
}


// ==========================================
// PODKLASA: Manager (Zadatak 1)
// ==========================================

// Klasa Manager nasljeđuje klasu Employee pomoću ključne riječi extends.
// Manager automatski dobija dostupne metode bazne klase Employee.
class Manager extends Employee {

    // Privatni atribut koji predstavlja dodatni bonus menadžera.
    private double bonus;


    // Konstruktor klase Manager prima ime, ID, osnovnu platu i bonus.
    public Manager(String name, int id, double salary, double bonus) {

        // super() poziva konstruktor roditeljske klase Employee.
        // Time se inicijalizuju ime, ID i osnovna plata.
        super(name, id, salary);

        // Dodjeljivanje vrijednosti bonusa atributu klase Manager.
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus, LocalDate hireDay) {
        super(name, id, salary, hireDay);
        this.bonus = bonus;
    }


    // Getter metoda koja vraća vrijednost bonusa menadžera.
    public double getBonus() {
        return bonus;
    }


    // Metoda koja računa ukupnu platu menadžera.
    // Ukupna plata predstavlja zbir osnovne plate i bonusa.
    public double getTotalSalary() {
        return getSalary() + bonus;
    }


    // @Override označava da se redefiniše metoda naslijeđena iz bazne klase.
    // Ova verzija metode work() ima drugačije ponašanje za menadžera.
    @Override
    public void work() {

        // getName() preuzima ime menadžera iz bazne klase.
        // Ispisuje se poruka da menadžer upravlja timom.
        System.out.println(getName() + " is managing the team.");
    }


    // Redefinisanje metode getDetails() iz bazne klase.
    @Override
    public String getDetails() {

        // super.getDetails() poziva originalnu metodu bazne klase.
        // Na postojeće podatke dodaje se i podatak o bonusu.
        return super.getDetails() + ", Bonus: $" + bonus;
    }

    @Override
    public Manager clone() { return (Manager) super.clone(); }
}


// ==========================================
// PODKLASA: Intern (Zadatak 1)
// ==========================================

// Klasa Intern predstavlja zaposlenika koji obavlja praksu.
// Nasljeđuje osnovne karakteristike iz klase Employee.
class Intern extends Employee {

    // Trajanje prakse u mjesecima.
    private int duration;

    // Škola ostavljena radi kompatibilnosti sa starim podacima.
    private String school;


    // Konstruktor klase Intern prima osnovne podatke i naziv škole.
    public Intern(String name, int id, double salary, String school) {

        // Poziv konstruktora bazne klase radi inicijalizacije naslijeđenih atributa.
        super(name, id, salary);

        // Dodjeljivanje naziva obrazovne ustanove atributu school.
        this.school = school;
        this.duration = 6; // trajanje podrazumijevano za stare zapise
    }

    public Intern(String name, int id, double salary, int duration) {
        this(name, id, salary, duration, "Nije navedeno", LocalDate.now());
    }

    public Intern(String name, int id, double salary, int duration, String school, LocalDate hireDay) {
        super(name, id, salary, hireDay);
        if (duration <= 0) throw new IllegalArgumentException("Trajanje prakse mora biti veće od nule.");
        this.duration = duration;
        this.school = school == null ? "Nije navedeno" : school;
    }

    public int getDuration() { return duration; }


    // Getter metoda koja vraća naziv obrazovne ustanove praktikanta.
    public String getSchool() {
        return school;
    }


    // Redefinisanje metode work() za klasu Intern.
    @Override
    public void work() {

        // Ispisuje se poruka da praktikant uči i pomaže u radu.
        // getName() preuzima njegovo ime, a school naziv ustanove.
        System.out.println(getName() + " is learning and assisting (Intern from " + school + ").");
    }


    // Redefinisanje metode getDetails() kako bi uključila podatak o školi.
    @Override
    public String getDetails() {

        // Preuzimaju se osnovni podaci iz bazne klase.
        // Na njih se dodaje naziv obrazovne ustanove.
        return super.getDetails() + ", Internship duration: " + duration + " months, School: " + school;
    }

    @Override
    public Intern clone() { return (Intern) super.clone(); }
}


// ==========================================
// GLAVNA KLASA: Main
// ==========================================

// Glavna klasa programa.
// Sadrži main() metodu od koje počinje izvršavanje Java programa.
public class Main {

    // Main metoda predstavlja ulaznu tačku svakog standardnog Java programa.
    // public omogućava pristup metodi, static znači da se poziva bez objekta klase.
    // void označava da metoda ne vraća vrijednost.
    // String[] args omogućava prihvatanje argumenata iz komandne linije.
    public static void main(String[] args) {

        // Kreiranje liste employees koja može sadržavati objekte klase Employee
        // i njenih podklasa Manager i Intern.
        // ArrayList omogućava dinamičko dodavanje i uklanjanje elemenata.
        List<Employee> employees = new ArrayList<>();

        // Definisanje naziva tekstualne datoteke u koju će se spremati podaci.
        String filename = "zaposlenici.txt";


        // 1. INICIJALNO PUNJENJE LISTE TESTNIM PODACIMA

        // Kreiranje običnog zaposlenika i dodavanje u listu.
        // Parametri predstavljaju ime, ID i osnovnu platu.
        employees.add(new Employee("Alice", 101, 50000, LocalDate.of(2020, 2, 10)));

        // Kreiranje menadžera i dodavanje u listu.
        // Pored osnovnih podataka, menadžer ima i bonus.
        employees.add(new Manager("Bob", 102, 80000, 15000, LocalDate.of(2018, 5, 1)));

        // Kreiranje drugog menadžera s drugačijim podacima.
        employees.add(new Manager("Charlie", 103, 90000, 20000, LocalDate.of(2016, 8, 15)));

        // Kreiranje praktikanta koji je povezan s ustanovom IPI Akademija.
        employees.add(new Intern("Mirza", 104, 25000, 6, "IPI Akademija", LocalDate.of(2025, 10, 1)));


        // Ispis naslova prvog koraka programa.
        System.out.println("====== 1. KORAK: SPREMANJE PODATAKA U DATOTEKU ======");


        // Pozivanje metode koja sprema sve zaposlenike iz liste u datoteku.
        // Metodi se prosljeđuju lista zaposlenika i naziv datoteke.
        saveEmployeesToFile(employees, filename);


        // PRAŽNJENJE LISTE

        // clear() uklanja sve elemente iz liste employees.
        // Podaci su uklonjeni iz liste u memoriji, ali ostaju sačuvani u datoteci.
        employees.clear();

        // Ispisujemo trenutnu veličinu liste kako bismo potvrdili da je prazna.
        // size() vraća broj elemenata koji se trenutno nalaze u listi.
        System.out.println("\n[Info] Lista u memoriji je ispražnjena. Veličina liste: " + employees.size());


        // Ispis naslova drugog koraka programa.
        System.out.println("\n====== 2. KORAK: UČITAVANJE PODATAKA IZ DATOTEKE ======");


        // Pozivanje metode koja čita podatke iz datoteke i vraća ih u listu.
        // Na taj način dokazujemo da podaci nisu izgubljeni nakon clear().
        loadEmployeesFromFile(employees, filename);


        // Ispis naslova trećeg koraka programa.
        System.out.println("\n====== 3. KORAK: POKRETANJE OSTALIH ZADATAKA NAD UČITANIM PODACIMA ======");


        // PRIKAZ UČITANIH OBJEKATA I DEMONSTRACIJA POLIMORFIZMA

        // Ispis naslova dijela programa koji prikazuje zaposlenike.
        System.out.println("--- Prikaz učitanih zaposlenika ---");


        // For-each petlja prolazi kroz sve elemente liste employees.
        // Svaki element se privremeno predstavlja varijablom emp.
        // Tip Employee omogućava obradu različitih podklasa kroz isti tip reference.
        for (Employee emp : employees) {

            // Pozivanje getDetails() metode ispisuje podatke zaposlenika.
            // Zbog polimorfizma izvršava se odgovarajuća verzija metode.
            System.out.println(emp.getDetails());

            // Pozivanje metode work() prikazuje aktivnost konkretnog zaposlenika.
            // Manager, Intern i Employee imaju različite implementacije ove metode.
            emp.work();

            // Ispis razdjelnika radi preglednijeg prikaza rezultata.
            System.out.println("------------------------------------------------");
        }


        // ZADATAK 2: IZRAČUN UKUPNIH TROŠKOVA PLATA

        // Pozivanje metode koja računa ukupne troškove plata svih zaposlenika.
        calculateTotalExpenses(employees);


        // ZADATAK 5: PRONALAŽENJE ZAPOSLENIKA MJESECA

        // Pozivanje metode koja pronalazi zaposlenika s najvećom ukupnom zaradom.
        findEmployeeOfTheMonth(employees);


        // ZADATAK 3: SORTIRANJE ZAPOSLENIKA PO PLATI

        // Pozivanje metode koja sortira zaposlenike prema ukupnoj zaradi silazno.
        sortEmployeesBySalary(employees);

        // Prirodno sortiranje preko Comparable<Employee> (po ID-u).
        Collections.sort(employees);
        System.out.println("\n[Zadatak 2 sa slike] Sortiranje po ID-u:");
        for (Employee emp : employees) System.out.println(emp.getDetails());

        // Dodatno sortiranje po datumu zaposlenja.
        sortEmployeesByHireDay(employees);

        // Demonstracija kloniranja, pretrage po imenu i pretrage po ID-u.
        if (!employees.isEmpty()) {
            Employee kopija = employees.get(0).clone();
            System.out.println("\nKlonirani zaposlenik: " + kopija.getDetails());
        }
        findEmployee(employees, "Mirza");
        findEmployee(employees, "102");
    }


    // ==========================================
    // METODA ZA UČITAVANJE PODATAKA IZ DATOTEKE
    // ==========================================

    // Ova metoda čita podatke iz tekstualne datoteke i na osnovu njih
    // ponovo kreira odgovarajuće objekte Employee, Manager ili Intern.
    // Prima listu u koju će smjestiti objekte i naziv datoteke.
    public static void loadEmployeesFromFile(List<Employee> employees, String filename) {

        // try-with-resources automatski zatvara datoteku nakon završetka rada.
        // FileReader otvara datoteku, a BufferedReader omogućava čitanje liniju po liniju.
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            // Promjenljiva line služi za čuvanje trenutno pročitane linije.
            String line;

            // Brojač evidentira koliko je zaposlenika uspješno obrađeno.
            int brojac = 0;


            // while petlja čita datoteku sve dok postoji naredna linija.
            // readLine() vraća tekst linije, a null kada dođe do kraja datoteke.
            while ((line = reader.readLine()) != null) {

                // Provjera da li je linija prazna ili sadrži samo razmake.
                // continue preskače takvu liniju i prelazi na sljedeću.
                if (line.trim().isEmpty()) continue;


                // split(",") dijeli pročitanu liniju na dijelove koristeći zarez.
                // Dobijeni dijelovi smještaju se u niz tokens.
                String[] tokens = line.split(",", -1);

                // Prvi element niza predstavlja tip zaposlenika.
                String tip = tokens[0];

                // Drugi element predstavlja ime zaposlenika.
                String name = tokens[1];

                // Treći element predstavlja ID.
                // parseInt() pretvara tekstualni podatak u cijeli broj.
                int id = Integer.parseInt(tokens[2]);

                // Četvrti element predstavlja osnovnu platu.
                // parseDouble() pretvara tekstualni podatak u decimalni broj.
                double salary = Double.parseDouble(tokens[3]);


                // switch provjerava vrijednost varijable tip i određuje
                // koju vrstu objekta treba kreirati na osnovu podataka iz datoteke.
                switch (tip) {

                    // Ako je tip EMPLOYEE, kreira se obični zaposlenik.
                    case "EMPLOYEE":

                        // Kreiranje objekta Employee i dodavanje u listu.
                        employees.add(new Employee(name, id, salary,
                                tokens.length > 4 && isDate(tokens[4]) ? LocalDate.parse(tokens[4]) : LocalDate.now()));

                        // break prekida izvršavanje switch bloka.
                        break;


                    // Ako je tip MANAGER, kreira se objekat menadžera.
                    case "MANAGER":

                        // Peti element niza sadrži bonus menadžera.
                        // Tekstualna vrijednost pretvara se u decimalni broj.
                        boolean managerHasDate = tokens.length > 5 && isDate(tokens[4]);
                        double bonus = Double.parseDouble(tokens[managerHasDate ? 5 : 4]);

                        // Kreiranje objekta Manager i dodavanje u listu.
                        employees.add(managerHasDate
                                ? new Manager(name, id, salary, bonus, LocalDate.parse(tokens[4]))
                                : new Manager(name, id, salary, bonus));

                        // Prekid switch bloka.
                        break;


                    // Ako je tip INTERN, kreira se objekat praktikanta.
                    case "INTERN":

                        // Peti element niza sadrži naziv obrazovne ustanove.
                        boolean internHasDate = tokens.length > 5 && isDate(tokens[4]);

                        // Kreiranje objekta Intern i dodavanje u listu.
                        if (internHasDate) {
                            int duration = Integer.parseInt(tokens[5]);
                            String school = tokens.length > 6 ? tokens[6] : "Nije navedeno";
                            employees.add(new Intern(name, id, salary, duration, school, LocalDate.parse(tokens[4])));
                        } else {
                            // U starom formatu peto polje je naziv škole.
                            employees.add(new Intern(name, id, salary, tokens.length > 4 ? tokens[4] : "Nije navedeno"));
                        }

                        // Prekid switch bloka.
                        break;


                    // Default se izvršava ako tip zaposlenika nije prepoznat.
                    default:

                        // Ispis upozorenja o nepoznatom tipu zaposlenika.
                        System.out.println("Nepoznat tip zaposlenika u datoteci: " + tip);
                }

                // Povećavanje brojača nakon obrade linije.
                brojac++;
            }


            // Ispis informacije o broju učitanih zaposlenika i nazivu datoteke.
            System.out.println("[Učitavanje] Uspješno učitano " + brojac + " zaposlenika iz datoteke '" + filename + "'.");


            // catch obrađuje moguće greške prilikom čitanja datoteke ili obrade podataka.
            // IOException označava grešku pri radu s datotekom.
            // ArrayIndexOutOfBoundsException označava pristup nepostojećem elementu niza.
            // NumberFormatException označava neispravnu pretvorbu teksta u broj.
        } catch (IOException | RuntimeException e) {

            // getMessage() vraća opis nastale greške kako bi korisnik znao šta se dogodilo.
            System.out.println("Greška prilikom čitanja datoteke: " + e.getMessage());
        }
    }

    // Provjerava da li tekst ima ISO format datuma (YYYY-MM-DD).
    private static boolean isDate(String value) {
        try { LocalDate.parse(value); return true; }
        catch (RuntimeException e) { return false; }
    }


    // ==========================================
    // METODA ZA SPREMANJE PODATAKA U DATOTEKU
    // ==========================================

    // ZADATAK 4: Ova metoda sprema podatke svih zaposlenika u tekstualnu datoteku.
    // Prima listu zaposlenika i naziv datoteke u koju se podaci upisuju.
    public static void saveEmployeesToFile(List<Employee> employees, String filename) {

        // try-with-resources otvara datoteku i automatski je zatvara nakon upisa.
        // FileWriter u ovom obliku kreira datoteku ako ne postoji,
        // a ako postoji, zamjenjuje njen prethodni sadržaj.
        try (FileWriter writer = new FileWriter(filename)) {

            // For-each petlja prolazi kroz sve zaposlenike u listi.
            for (Employee emp : employees) {


                // instanceof provjerava da li je objekat emp instanca klase Manager.
                // Koristi se jer lista sadrži različite vrste zaposlenika.
                if (emp instanceof Manager) {

                    // Eksplicitno pretvaranje reference Employee u Manager.
                    // Omogućava pristup dodatnim metodama klase Manager.
                    Manager m = (Manager) emp;

                    // Upis podataka menadžera u datoteku.
                    // MANAGER je oznaka tipa, a ostali podaci odvojeni su zarezima.
                    // getBonus() preuzima dodatni bonus menadžera.
                    writer.write("MANAGER," + m.getName() + "," + m.getId() + "," + m.getSalary() + "," + m.getHireDay() + "," + m.getBonus() + System.lineSeparator());


                    // Ako objekat nije Manager, provjerava se da li je Intern.
                } else if (emp instanceof Intern) {

                    // Pretvaranje reference Employee u Intern.
                    // Time se omogućava pristup metodi getSchool().
                    Intern i = (Intern) emp;

                    // Upis podataka praktikanta u datoteku.
                    // INTERN označava vrstu zaposlenika.
                    // Pored osnovnih podataka upisuje se i naziv škole.
                    writer.write("INTERN," + i.getName() + "," + i.getId() + "," + i.getSalary() + "," + i.getHireDay() + "," + i.getDuration() + "," + i.getSchool() + System.lineSeparator());


                    // Ako objekat nije ni Manager ni Intern, tretira se kao Employee.
                } else {

                    // Upis osnovnih podataka običnog zaposlenika.
                    // EMPLOYEE predstavlja oznaku njegove vrste.
                    writer.write("EMPLOYEE," + emp.getName() + "," + emp.getId() + "," + emp.getSalary() + "," + emp.getHireDay() + System.lineSeparator());
                }
            }


            // Poruka koja potvrđuje da je upis podataka uspješno završen.
            System.out.println("[Zadatak 4] Podaci su uspješno spremljeni u datoteku: " + filename);


            // Obrada greške koja može nastati prilikom pisanja u datoteku.
        } catch (IOException e) {

            // Ispis detalja o grešci prilikom upisa podataka.
            System.out.println("Greška prilikom pisanja u datoteku: " + e.getMessage());
        }
    }


    // ==========================================
    // ZADATAK 2: IZRAČUN UKUPNIH TROŠKOVA PLATA
    // ==========================================

    // Metoda računa ukupne troškove plata svih zaposlenika.
    // Za menadžere se računa osnovna plata zajedno s bonusom.
    public static void calculateTotalExpenses(List<Employee> employees) {

        // Promjenljiva total počinje od nule i čuva zbir svih plata.
        double total = 0;


        // For-each petlja prolazi kroz sve zaposlenike u listi.
        for (Employee emp : employees) {

            // Provjera da li je trenutni zaposlenik menadžer.
            if (emp instanceof Manager) {

                // Pretvaranje reference Employee u Manager.
                Manager mgr = (Manager) emp;

                // Dodavanje ukupne plate menadžera, zajedno s bonusom, u zbir.
                total += mgr.getTotalSalary();

            } else {

                // Ako zaposlenik nije menadžer, dodaje se samo njegova osnovna plata.
                total += emp.getSalary();
            }
        }


        // Ispis ukupnih troškova plata svih zaposlenika.
        // Rezultat uključuje i bonuse menadžera.
        System.out.println("\n[Zadatak 2] Ukupni troškovi plata (uključujući bonuse): $" + total);
    }


    // ==========================================
    // ZADATAK 3: SORTIRANJE ZAPOSLENIKA PO PLATI
    // ==========================================

    // Metoda sortira zaposlenike prema ukupnoj zaradi u silaznom redoslijedu.
    // To znači da se zaposlenik s najvećom zaradom nalazi na prvom mjestu.
    public static void sortEmployeesBySalary(List<Employee> employees) {

        // Collections.sort() sortira elemente liste.
        // Drugi argument predstavlja Comparator koji definiše pravilo sortiranja.
        Collections.sort(employees, new Comparator<Employee>() {

            // compare() poredi dva zaposlenika i određuje njihov međusobni redoslijed.
            @Override
            public int compare(Employee e1, Employee e2) {

                // Određivanje ukupne zarade prvog zaposlenika.
                // Ako je menadžer, uzima se osnovna plata i bonus.
                // U suprotnom se uzima samo osnovna plata.
                double s1 = (e1 instanceof Manager)
                        ? ((Manager) e1).getTotalSalary()
                        : e1.getSalary();


                // Određivanje ukupne zarade drugog zaposlenika.
                // I ovdje se menadžeru uračunava bonus.
                double s2 = (e2 instanceof Manager)
                        ? ((Manager) e2).getTotalSalary()
                        : e2.getSalary();


                // Double.compare() poredi dvije decimalne vrijednosti.
                // Zamjena redoslijeda s2 i s1 omogućava sortiranje od najveće ka najmanjoj zaradi.
                return Double.compare(s2, s1);
            }
        });


        // Ispis naslova nakon završenog sortiranja.
        System.out.println("\n[Zadatak 3] Zaposlenici sortirani po ukupnoj zaradi (Silazno):");


        // Prolazak kroz sortiranu listu zaposlenika.
        for (Employee emp : employees) {

            // Određivanje trenutne ukupne zarade zaposlenika.
            // Menadžeru se dodaje bonus, dok se ostalima uzima osnovna plata.
            double trenutnaZarada = (emp instanceof Manager)
                    ? ((Manager) emp).getTotalSalary()
                    : emp.getSalary();


            // Ispis imena, ID broja i ukupne zarade zaposlenika.
            System.out.println(" - " + emp.getName() + " (ID: " + emp.getId() + "): $" + trenutnaZarada);
        }
    }


    // ==========================================
    // SORTIRANJE PO DATUMU ZAPOSLENJA I PRETRAGA
    // ==========================================

    public static void sortEmployeesByHireDay(List<Employee> employees) {
        Collections.sort(employees, Comparator.comparing(Employee::getHireDay));
        System.out.println("\nZaposlenici sortirani po datumu zaposlenja:");
        for (Employee emp : employees)
            System.out.println(emp.getHireDay() + " - " + emp.getName() + " (" + emp.getYearsOfService() + " godina)");
    }

    // Pretražuje listu po punom imenu ili ID-u i ispisuje pronađenog zaposlenika.
    public static Employee findEmployee(List<Employee> employees, String query) {
        for (Employee emp : employees) {
            if (emp.getName().equalsIgnoreCase(query.trim())
                    || String.valueOf(emp.getId()).equals(query.trim())) {
                System.out.println("\nPronađen zaposlenik za '" + query + "':");
                System.out.println(emp.getDetails());
                return emp;
            }
        }
        System.out.println("\nZaposlenik nije pronađen: " + query);
        return null;
    }

    // ==========================================
    // ZADATAK 5: PRONALAŽENJE ZAPOSLENIKA MJESECA
    // ==========================================

    // Metoda pronalazi zaposlenika koji ima najveću ukupnu zaradu.
    // Menadžerima se pri poređenju uračunava i bonus.
    public static void findEmployeeOfTheMonth(List<Employee> employees) {

        // Provjera da li je lista prazna.
        // Ako nema zaposlenika, metoda se odmah završava.
        if (employees.isEmpty()) return;


        // Pretpostavljamo da je prvi zaposlenik u listi zaposlenik mjeseca.
        // Njegova zarada predstavlja početnu maksimalnu vrijednost.
        Employee zaposlenikMjeseca = employees.get(0);


        // Određivanje početne maksimalne plate.
        // Ako je prvi zaposlenik menadžer, uračunava se i njegov bonus.
        // U suprotnom se uzima samo osnovna plata.
        double maksimalnaPlata = (zaposlenikMjeseca instanceof Manager)
                ? ((Manager) zaposlenikMjeseca).getTotalSalary()
                : zaposlenikMjeseca.getSalary();


        // For-each petlja prolazi kroz sve zaposlenike kako bi pronašla najveću zaradu.
        for (Employee emp : employees) {

            // Određivanje ukupne zarade trenutnog zaposlenika.
            // Menadžeru se dodaje bonus, a ostalima se uzima osnovna plata.
            double trenutnaPlata = (emp instanceof Manager)
                    ? ((Manager) emp).getTotalSalary()
                    : emp.getSalary();


            // Poređenje trenutne zarade s do sada najvećom pronađenom zaradom.
            if (trenutnaPlata > maksimalnaPlata) {

                // Ako je trenutna zarada veća, postaje nova maksimalna vrijednost.
                // Ovo je ispravka greške iz originalnog koda:
                // koristimo trenutnaPlata, a ne nepostojeću varijablu trenchesPlata.
                maksimalnaPlata = trenutnaPlata;

                // Trenutni zaposlenik postaje novi zaposlenik mjeseca.
                zaposlenikMjeseca = emp;
            }
        }


        // Ispis imena zaposlenika s najvećom ukupnom zaradom i njegove zarade.
        System.out.println("\n[Zadatak 5] Zaposlenik mjeseca je: " + zaposlenikMjeseca.getName() + " sa zaradom od $" + maksimalnaPlata);
    }
}
