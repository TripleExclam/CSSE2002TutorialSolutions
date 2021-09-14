package week8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Schedule {
    private List<Flight> flights;

    public Schedule(List<Flight> flights) {
        this.flights = flights;
    }

    private static Schedule makeSchedule() {
        List<Flight> flights = new ArrayList<>();
        Airport brisbane = new Airport("Brisbane International", "bne");
        Airport sydney = new Airport("Sydney International", "syd");
        Airport jfk = new Airport("John F. Kennedy International", "jfk");
        Airport dubai = new Airport("Dubai International", "dxb");
        flights.add(new Flight(1192, brisbane, sydney, DayOfWeek.MON));
        flights.add(new Flight(8, sydney, dubai, DayOfWeek.SUN));
        flights.add(new Flight(349, jfk, brisbane, DayOfWeek.WED));
        return new Schedule(flights);
    }

    private List<Airport> getConnectedAirports() {
        List<Airport> seenAirports = new ArrayList<>();
        for (Flight flight : this.flights) {
            if (!seenAirports.contains(flight.getOrigin())) {
                seenAirports.add(flight.getOrigin());
            }
            if (!seenAirports.contains(flight.getDestination())) {
                seenAirports.add(flight.getDestination());
            }
        }
        return seenAirports;
    }

    public void save(String filename)
            throws IOException {
        BufferedWriter bw = new BufferedWriter(
                new FileWriter(filename));
        bw.write(toString());
        bw.close();
    }

    private static int readNumber(String numText)
            throws BadScheduleException {
        // read a number or throw HINT: parseInt
        int num;
        try {
            num = Integer.parseInt(numText);
        } catch (NumberFormatException nfe) {
            throw new BadScheduleException();
        }
        return num;
    }

    private static String readLine(BufferedReader br)
            throws BadScheduleException {
        String text;
        try {
            while ((text = br.readLine()) != null) {
                if (!text.startsWith("//")) {
                    return text;
                }
            }
        } catch (IOException ioe) {
            throw new BadScheduleException();
        }

        throw new BadScheduleException();
    }

    /**
     * CHALLENGE: Allow arbitrarily many comments in a file
     */
    public static Schedule load(String filename)
            throws FileNotFoundException, BadScheduleException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        List<Flight> flights = new ArrayList<>();
        List<Airport> airports = new ArrayList<>();

        int numAirports = readNumber(readLine(reader));
        int numFlights = readNumber(readLine(reader));

        for (int i = 0; i < numAirports; i++) {
            airports.add(readAirport(reader));
        }

        for (int i = 0; i < numFlights; i++) {
            flights.add(readFlight(reader, airports));
        }

        return new Schedule(flights);
    }

    private static Airport readAirport(BufferedReader br)
            throws BadScheduleException {
        String text = readLine(br);
        String[] items = text.split("\\|");
        if (items.length != 2 || items[1].length() != 3) {
            throw new BadScheduleException();
        }

        return new Airport(items[0], items[1]);
    }
// matthew.burton@uq.edu.au
    private static Flight readFlight(BufferedReader br, List<Airport> ports)
            throws BadScheduleException {
        String text = readLine(br);
        String[] items = text.split("\\|");
        if (items.length != 4) {
            throw new BadScheduleException();
        }

        int flightNum = readNumber(items[0]);
        Airport origin = matchCode(items[1], ports);
        Airport destination = matchCode(items[2], ports);
        DayOfWeek day = DayOfWeek.valueOf(items[3]);

        return new Flight(flightNum, origin, destination, day);
    }

    private static Airport matchCode(String code, List<Airport> ports)
            throws BadScheduleException {
        for (Airport port : ports) {
            if (port.getCode().equals(code)) {
                return port;
            }
        }

        throw new BadScheduleException();
    }

    /**
     * Returns the string representation of this schedule, in the following
     * format:
     *
     * where each airport and flight line contains the toString() representation
     * of that airport or flight.
     *
     * Lines should be separated using a platform-independent line separator.
     *
     * @return string representation of schedule
     */
    @Override
    public String toString() {
        StringJoiner sb =
                new StringJoiner(System.lineSeparator());
        List<Airport> connected = getConnectedAirports();

        sb.add("" + connected.size());
        sb.add("" + flights.size());
        for (Airport air : connected) {
            sb.add(air.toString());
        }

        for (Flight fly : flights) {
            sb.add(fly.toString());
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException,
            BadScheduleException {
        Schedule schedule = makeSchedule();
        System.out.println(schedule);

        schedule.save("save.txt");
        Schedule newSchedule = load("save.txt");
        System.out.println(newSchedule);
    }
}
