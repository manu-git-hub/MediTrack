import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.repository.PatientRepository;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello World");

        PatientRepository repository = new PatientRepository();
        repository.addPatient(new Patient(1, "abc", "abc", "123", "abc", 16));
        System.out.println(repository.getPatients());
        //repository.getPatientById(1);
        //repository.addPatient(p);
        //repository.updatePatient(1,"Singh", "Mumbai", "singh@gmail.com", "1010101");
        //repository.deletePatient(1);

    }
}
