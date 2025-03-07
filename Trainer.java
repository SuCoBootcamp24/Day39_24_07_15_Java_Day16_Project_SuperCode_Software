import java.time.LocalDate;
import java.util.ArrayList;

public class Trainer extends Person {
    private ArrayList<String> licenses;
    private LocalDate inCompanySice;
    private ArrayList<Module> modulList = new ArrayList<>();

    public Trainer(String firstname, String lastname, LocalDate birthday, String address, String email, LocalDate inCompanySince) {
        super(firstname, lastname, birthday, address, email);
        this.inCompanySice = inCompanySince;
        this.licenses = new ArrayList<>();
    }

    // getters and setters()
    public ArrayList<String> getLicenses() {
        return licenses;
    }

    //---
    public LocalDate getInCompanySice() {
        return inCompanySice;
    }

    //---
    public ArrayList<Module> getModulList() {
        return modulList;
    }


    //-----other----
    public void addModuleToList(Module module) {
        if(!modulList.contains(module)) modulList.add(module);
    }


    public void addLicenseToList(String license) {
        if (license.isEmpty())
            throw new IllegalArgumentException("String of new lincense is Empty.");
        if(!getLicenses().contains(license)) licenses.add(license);
    }

    public boolean hasLicense(String license) {
        if (getLicenses().contains(license)) {
            return true;
        }
        return false;
    }

    public boolean TrainerIsFree(Module module) {
        
        for (Module m : getModulList()) {
            if(module.getEnd().isAfter(m.getStart()) && module.getStart().isBefore(m.getEnd())) {
                return false;
            }
        }
        return true;
    }

    public long getWorkingDaysInModulesAssigned() {
        long workingDays = 0;
        for (Module m : getModulList()) {
            workingDays += m.calcAllModuleTimeInDays();
        }
        return workingDays;
    }

    @Override
    public String toString() {
        return "Trainer " + getID() + " " +
                getFirstname() + " " + getLastname() + ": " +
                "DOB: " + getBIRTHDAY() +
                " Licenses: " + licenses.toString() +
                " Number Modules : " + modulList.size();
    }
}
