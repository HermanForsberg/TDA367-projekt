package Model;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class DayWeekTracker {
    private LocalDate lastCheckedDate;
    private final String FILENAME = "lastCheckedDate.ser"; // File to store the date

    public DayWeekTracker() {
        // Load last checked date from file if available
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            lastCheckedDate = (LocalDate) inputStream.readObject();
        } catch (FileNotFoundException e) {
            lastCheckedDate = LocalDate.now();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean lastDateFileExists(){
        String fileName = "lastCheckedDate.ser";
        File file = new File(fileName);
        return file.exists();
    }

    public boolean isNewDay() {
        LocalDate currentDate = LocalDate.now();

        if (!currentDate.isEqual(lastCheckedDate)) {
            lastCheckedDate = currentDate;
            System.out.println("New day yay");
            return true;
        }
        return false;
    }

    public boolean isNewWeek() {
        LocalDate currentDate = LocalDate.now();

        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int currentWeek = currentDate.get(weekFields.weekOfWeekBasedYear());
        int lastCheckedWeek = lastCheckedDate.get(weekFields.weekOfWeekBasedYear());

        if (currentWeek != lastCheckedWeek) {
            lastCheckedDate = currentDate;
            System.out.println("New week yay");
            return true;
        }
        return false;
    }

    public void saveLastCheckedDate() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            outputStream.writeObject(lastCheckedDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDayToString(){
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    @VisibleForTesting
    public void setLastCheckedDate(LocalDate lastCheckedDate) {
        this.lastCheckedDate = lastCheckedDate;
    }
}
