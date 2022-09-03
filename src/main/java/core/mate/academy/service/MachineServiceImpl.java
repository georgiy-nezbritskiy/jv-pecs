package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        if (type == Bulldozer.class) {
            MachineProducer<Bulldozer> bulldozerProducer = new BulldozerProducer();
            return new ArrayList<>(bulldozerProducer.get());
        }
        if (type == Excavator.class) {
            MachineProducer<Excavator> excavatorProducer = new ExcavatorProducer();
            return new ArrayList<>(excavatorProducer.get());
        }
        if (type == Truck.class) {
            MachineProducer<Truck> truckProducer = new TruckProducer();
            return new ArrayList<>(truckProducer.get());
        }
        return new ArrayList<>();
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        Collections.fill(machines, value);
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }

    }
}
