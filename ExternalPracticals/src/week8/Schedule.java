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

    public void save(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(
                new FileWriter(filename));
        bw.write(this.toString());
        bw.close();
    }

    private static int readNumber(String line)
            throws BadScheduleException {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException nfe) {
            throw new BadScheduleException();
        }
    }

    private static String readLine(BufferedReader reader)
            throws BadScheduleException {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("//")) {
                    return line;
                }
            }
        } catch (IOException ioe) {
            throw new BadScheduleException();
        }
        throw new BadScheduleException();
    }

    public static Schedule load(String filename)
            throws FileNotFoundException, BadScheduleException {

        BufferedReader reader = new BufferedReader(
                new FileReader(filename));
        List<Airport> ports = new ArrayList<>();
        List<Flight> flights = new ArrayList<>();

        int numConnected = readNumber(readLine(reader));
        int numFlights = readNumber(readLine(reader));

        for (int i = 0; i < numConnected; i++) {
            ports.add(readAirport(reader));
        }

        for (int i = 0; i < numFlights; i++) {
            flights.add(readFlight(reader, ports));
        }

        return new Schedule(flights);
    }

    private static Airport findPort(String toFind, List<Airport> ports)
            throws BadScheduleException {

        for (Airport port : ports) {
            if (port.getCode().equals(toFind)) {
                return port;
            }
        }

        throw new BadScheduleException();
    }

    private static Flight readFlight(BufferedReader reader, List<Airport> ports)
            throws BadScheduleException {
        String line = readLine(reader);
        String[] items = line.split("\\|");

        if (items.length != 4 && items[3].length() != 3) {
            throw new BadScheduleException();
        }

        int flightNum = readNumber(items[0]);
        Airport origin = findPort(items[1], ports);
        Airport destination = findPort(items[2], ports);
        DayOfWeek day = DayOfWeek.valueOf(items[3]);

        return new Flight(flightNum, origin, destination, day);
    }

    private static Airport readAirport(BufferedReader reader)
            throws BadScheduleException {
        String line = readLine(reader);
        String[] items = line.split("\\|");

        if (items.length != 2 && items[1].length() != 3) {
            throw new BadScheduleException();
        }

        return new Airport(items[0], items[1]);
    }

    /**
     * Returns the string representation of this schedule, in the following
     * format:
     *
     * numConnectedAirports
     * numFlights
     * airport1
     * airport2
     * ...
     * airportN
     * flight1
     * flight2
     * ...
     * flightM
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
        StringJoiner sj = new StringJoiner(System.lineSeparator()); // \r\n \n

        List<Airport> connected = getConnectedAirports();
        sj.add(connected.size() + "");
        sj.add(flights.size() + "");
        for (Airport airport : connected) {
            sj.add(airport.toString());
        }

        for (Flight flight : flights) {
            sj.add(flight.toString());
        }

        return sj.toString();
    }

    public static void main(String[] args) throws IOException,
            BadScheduleException {
        Schedule schedule = makeSchedule();
//        System.out.println(schedule);

//        schedule.save("Schedules/save.txt");
        Schedule newSchedule = load("Schedules/save.txt");
        System.out.println(newSchedule);
    }
    //matthew.burton@uq.edu.au
}
