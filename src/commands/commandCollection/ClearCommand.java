package commands.commandCollection;

import commands.Command;
import data.vehiclec.Vehicle;

import java.util.HashSet;

public class ClearCommand extends Command {

    @Override
    public void userExecute() {
        setName("clear");
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        vehicleCollection.clear();
        return ("Clearing ended✓");
    }
}
