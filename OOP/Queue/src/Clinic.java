import java.util.Timer;
import java.util.TimerTask;

public class Clinic {

    private Queue citizens;
    private Queue soldiers;
    private Queue critical;
    private PatientType lastTreated;


    public Clinic(){
        this.citizens = new Queue();
        this.soldiers = new Queue();
        this.critical = new Queue();
    }


    public void runClinic() {
        System.out.println("Clinic starts run now !");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Patient patient = nextPatient();
                if (patient != null) {
                    System.out.println("Entering next patiant...");
                    patient.printPatient();
                } else if (isEmpty()) {
                    System.out.println("No more patiants");
                    this.cancel();
                }
            }
        }, 0, 1000);
    }

    public boolean isEmpty(){
        return this.citizens.isEmpty() && this.soldiers.isEmpty() && this.critical.isEmpty();
    }


    public int signIn(Patient patient){
        int numBefore = 0;
        final int MAX_LENGTH = 10;

        if (patient.backetCase().length() > MAX_LENGTH) {
            this.critical.enqueue(patient);
            numBefore = this.critical.calcLength() - 1;
        } else {
            if (patient instanceof Solider) {
                this.soldiers.enqueue(patient);
                numBefore = this.soldiers.calcLength() - 1;
            }
            if (patient instanceof Citizen) {
                this.citizens.enqueue(patient);
                numBefore = this.citizens.calcLength() - 1;

            }
        }

        return numBefore;

    }

    public void printClinic(){
        System.out.println("------------------");
        System.out.println("Critical Queue:");
        this.critical.printQueue();
        System.out.println("------------------");

        System.out.println("------------------");
        System.out.println("Citizens Queue:");
        this.citizens.printQueue();
        System.out.println("------------------");

        System.out.println("------------------");
        System.out.println("Soldiers Queue:");
        this.soldiers.printQueue();
        System.out.println("------------------");

    }

    public Patient nextPatient(){
        if(!this.critical.isEmpty())
            return this.critical.dequeue().data();

        if(!this.citizens.isEmpty())
            return this.citizens.dequeue().data();

        if(!this.soldiers.isEmpty())
            return this.soldiers.dequeue().data();

        return null;

    }

    public void sortCritical() {
        int length = this.critical.calcLength();


            Patient p1 = this.critical.dequeue().data();
            Patient p2 = this.critical.dequeue().data();

            int iterationNum = 0;

            while (iterationNum < length) {
                if (p1.backetCase().length() < p2.backetCase().length()) {
                    this.critical.enqueue(p1);
                    p1 = this.critical.dequeue().data();
                } else {
                    this.critical.enqueue(p2);
                    p2 = this.critical.dequeue().data();
                }

                iterationNum++;
            }

            if (p1.backetCase().length() < p2.backetCase().length()) {
                this.critical.enqueue(p1);
                this.critical.enqueue(p2);

            } else {
                this.critical.enqueue(p2);
                this.critical.enqueue(p1);
            }

    }
}
